package org.support.project.web.logic;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.owasp.html.AttributePolicy;
import org.owasp.html.Handler;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.HtmlSanitizer;
import org.owasp.html.HtmlStreamRenderer;
import org.support.project.common.exception.ParseException;
import org.support.project.common.log.Log;
import org.support.project.common.log.LogFactory;
import org.support.project.di.Container;

public class SanitizingLogic {
	/** ログ */
	private static Log LOG = LogFactory.getLog(SanitizingLogic.class);

	public static SanitizingLogic get() {
		return Container.getComp(SanitizingLogic.class);
	}
	
	private static final String[] ALLOW_ELEMENTS = {
		"a", "b", "br", "div", "font", "i", "img", "input", "li", "ol", "hr", "l",
		"p", "span", "td", "ul", "pre", "code", "h1", "h2", "h3", "h4", "h5", "h6",
		"table", "thead", "tbody", "tr", "th", "th", "strong", "em", "blockquote"
	};
	
	private Transformer transformer = null;

	private static HtmlSanitizer.Policy makePolicy(Appendable buffer) {
		final HtmlStreamRenderer renderer = HtmlStreamRenderer.create(buffer, new Handler<IOException>() {
			public void handle(IOException ex) {
				// OPEN ITEM: Some other exception type more appropriate here?
				LOG.error("Error creating AntiSamy policy for HTML Sanitizer", ex);
			}
		}, new Handler<String>() {
			public void handle(String errorMessage) {
				LOG.error(errorMessage);
				// OPEN ITEM: Should we also throw something here??? If so what?
			}
		});
		
		return new HtmlPolicyBuilder().allowElements(ALLOW_ELEMENTS)
				.allowAttributes("checked", "type").onElements("input").allowAttributes("color").onElements("font").allowAttributes("href")
				.onElements("a").allowAttributes("src").onElements("img").allowAttributes("class", "id", "title").globally().allowAttributes("char")
				.matching(new AttributePolicy() {
					public String apply(String elementName, String attributeName, String value) {
						return value.length() == 1 ? value : null;
					}
				}).onElements("td").allowStandardUrlProtocols().requireRelNofollowOnLinks().allowStyling().build(renderer);
	}
	
	private void setUpTransformer() throws TransformerConfigurationException, TransformerFactoryConfigurationError {
		if (transformer == null) {
			transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "html");
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
//			transformer.setOutputProperty(OutputPropertiesFactory.S_KEY_INDENT_AMOUNT, String.valueOf(2));
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", String.valueOf(2));
		}
	}
	
	public String indent(String html) throws TransformerFactoryConfigurationError, TransformerException, IOException {
		setUpTransformer();
		StringBuilder builder = new StringBuilder();
		builder.append("<root>").append(html).append("</root>");
		byte[] bytes = builder.toString().getBytes();
		
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new ByteArrayInputStream(bytes);
			StreamSource src = new StreamSource(is);
			os = new ByteArrayOutputStream();
			StreamResult result = new StreamResult(os);
			transformer.transform(src, result);
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new StringReader(os.toString()));
				builder = new StringBuilder();
				String s;
				while((s = reader.readLine()) != null){
					if (!s.equals("<root>") && !s.equals("</root>")) {
						builder.append(s);
						builder.append("\n");
					}
				}
				return builder.toString();
			} finally {
				if (reader != null) {
					reader.close();
				}
			}
		} finally {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}
		}
	}

	public String sanitize(String untrustedHTML) throws ParseException {
		return sanitize(untrustedHTML, false);
	}

	public String sanitize(String untrustedHTML, boolean clean) throws ParseException {
		// PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
		// String safeHTML = policy.sanitize(untrustedHTML);
		StringBuilder sb = new StringBuilder();
		HtmlSanitizer.sanitize(untrustedHTML, makePolicy(sb));
		if (clean) {
			try {
				return indent(sb.toString());
			} catch (Exception e) {
				LOG.error("indent error.\n" + sb.toString(), e);
				throw new ParseException(e);
			}
		}
		return sb.toString();
	}

}
