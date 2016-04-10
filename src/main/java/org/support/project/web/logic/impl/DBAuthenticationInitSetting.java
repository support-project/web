package org.support.project.web.logic.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Security;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.support.project.common.serialize.SerializeUtils;
import org.support.project.common.util.StringUtils;
import org.support.project.di.Container;
import org.support.project.web.bean.User;
import org.support.project.web.dao.ManageUserDao;

public class DBAuthenticationInitSetting {

    /*
     * MD2 16 1.5～1.6 MD5 16 1.4～1.6 SHA-1 SHA SHA1 20 1.4～1.6 SHA-256 32 1.5～1.6 SHA-384 48 1.5～1.6 SHA-512 64 1.5～1.6
     */

    /**
     * main process
     * 
     * @param args args
     * @throws Exception Exception
     */
    public static void main(String[] args) throws Exception {
        DBAuthenticationInitSetting tool = new DBAuthenticationInitSetting();
        tool.start();
    }

    private void start() throws Exception {
        System.out.println("select menu.");
        menuselect();
    }

    private void menuselect() throws Exception {
        System.out.println("[1]. generate setting xml template.");
        System.out.println("[2]. list user.");
        System.out.println("[3]. add user.");
        System.out.println("[4]. edit user.");
        System.out.println("[5]. remove user.");
        System.out.println("[6]. login test.");
        System.out.println("[9]. hash Algorithms list.");
        System.out.println("[-1]. exit.");
        System.out.print("> ");

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String str = readLine(br);
        // br.close();

        if (!StringUtils.isInteger(str)) {
            System.out.println("wrong value. reselect.");
            menuselect();
            return;
        }

        int menu = Integer.parseInt(str);

        switch (menu) {
            case 1:
                generateXmlTemplate();
                break;
            case 2:
                listUser();
                break;
            case 3:
                addUser();
                break;
            case 4:
                editUser();
                break;

            case 5:
                deleteUser();
                break;

            case 6:
                testLogin();
                break;

            case 9:
                showHashAlgorithms();
                break;
            case -1:
                System.out.println("Bye.");
                System.exit(0);
                break;
            default:
                break;
        }

    }

    private void deleteUser() throws Exception {
        System.out.println("please input userId.");
        System.out.print("> ");

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String userId = readLine(br);

        System.out.println("please input performer.");
        System.out.print("> ");
        String performer = readLine(br);

        DBAuthenticationLogic logic = Container.getComp(DBAuthenticationLogic.class);
        logic.deleteUser(userId, performer);

        System.out.println("finish.");

        System.out.println("");

        System.out.println("select menu.");
        menuselect();
    }

    private void editUser() throws Exception {
        System.out.println("please input userId.");
        System.out.print("> ");

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String userId = readLine(br);

        System.out.println("please input password.");
        System.out.print("> ");
        String password = readLine(br);

        System.out.println("please input user name.");
        System.out.print("> ");
        String userName = readLine(br);

        System.out.println("please input roleId.");
        System.out.print("> ");
        String roleId = readLine(br);

        System.out.println("please input performer.");
        System.out.print("> ");
        String performer = readLine(br);

        DBAuthenticationLogic logic = Container.getComp(DBAuthenticationLogic.class);
        if (roleId.indexOf(",") != -1) {
            String[] roleIds = roleId.split(",");
            logic.updateUser(userId, password, userName, performer, null, roleIds);
        } else {
            logic.updateUser(userId, password, userName, performer, null, roleId);
        }

        System.out.println("finish.");

        System.out.println("");

        System.out.println("select menu.");
        menuselect();

    }

    private void testLogin() throws Exception {
        System.out.println("please input userId.");
        System.out.print("> ");

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String userId = readLine(br);

        System.out.println("please input password.");
        System.out.print("> ");
        String password = readLine(br);

        DBAuthenticationLogic logic = Container.getComp(DBAuthenticationLogic.class);
        boolean result = logic.auth(userId, password);

        System.out.println("" + result);

        System.out.println("finish.");

        System.out.println("");

        System.out.println("select menu.");
        menuselect();
    }

    private void listUser() throws Exception {
        ManageUserDao logic = Container.getComp(ManageUserDao.class);
        List<User> users = logic.listUsers();
        for (User user : users) {
            String str = user.getUserId() + "\t" + user.getUserName();
            // str += "\t" + DateUtils.formatTransferDateTime(user.getInsertDatetime());

            System.out.println(str);

            List<String> roles = user.getRoleIds();
            String roleStr = "";
            for (String string : roles) {
                roleStr += "\t" + string;
            }

            System.out.println(roleStr);
        }

        System.out.println("");

        System.out.println("select menu.");
        menuselect();
    }

    private void showHashAlgorithms() throws Exception {
        Set names = Security.getAlgorithms("MessageDigest");
        for (Iterator i = names.iterator(); i.hasNext();) {
            String name = (String) i.next();
            System.out.println(name);
        }

        System.out.println("");

        System.out.println("select menu.");
        menuselect();
    }

    private void addUser() throws Exception {
        System.out.println("please input userId.");
        System.out.print("> ");

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String userId = readLine(br);

        System.out.println("please input password.");
        System.out.print("> ");
        String password = readLine(br);

        System.out.println("please input user name.");
        System.out.print("> ");
        String userName = readLine(br);

        System.out.println("please input roleId.");
        System.out.print("> ");
        String roleId = readLine(br);

        System.out.println("please input performer.");
        System.out.print("> ");
        String performer = readLine(br);

        DBAuthenticationLogic logic = Container.getComp(DBAuthenticationLogic.class);
        if (roleId.indexOf(",") != -1) {
            String[] roleIds = roleId.split(",");
            logic.insertUser(userId, password, userName, performer, null, roleIds);
        } else {
            logic.insertUser(userId, password, userName, performer, null, roleId);
        }

        System.out.println("finish.");

        System.out.println("");

        System.out.println("select menu.");
        menuselect();
    }

    /**
     * 標準入力から値を読み込む
     * 
     * @param br BufferedReader
     * @return 読み込んだ値
     * @throws IOException
     */
    private String readLine(BufferedReader br) throws IOException {
        String read = br.readLine();
        if (StringUtils.isEmpty(read)) {
            return "";
        }
        return read;
    }

    private void generateXmlTemplate() throws Exception {
        System.out.println("please input output dir path.");
        System.out.print("> ");

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String str = readLine(br);

        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        File out = new File(file, "auth.xml");

        AuthParam param = new AuthParam();
        param.setUserTable("USERS");
        param.setUserTableUserIdColumn("USER_ID");
        param.setUserTableUserNameColumn("USER_NAME");
        param.setUserTableUserPasswordColumn("PASSWORD");

        param.setUserTableInsertUserIdColumn("INSERT_USER");
        param.setUserTableInsertDateTimeColumn("INSERT_DATETIME");
        param.setUserTableUpdateUserIdColumn("UPDATE_USER");
        param.setUserTableUpdateDateTimeColumn("UPDATE_DATETIME");

        param.setPasswordEncType("MD5");
        param.setRoleTable("USER_ROLES");
        param.setRoleTableRoleIdColumn("ROLE_ID");
        param.setRoleTableUserIdColumn("USER_ID");

        param.setRoleTableInsertUserIdColumn("INSERT_USER");
        param.setRoleTableInsertDateTimeColumn("INSERT_DATETIME");
        param.setRoleTableUpdateUserIdColumn("UPDATE_USER");
        param.setRoleTableUpdateDateTimeColumn("UPDATE_DATETIME");

        param.setRoleFunctionTable("ROLE_FUNCTIONS");
        param.setRoleFunctionTableRoleIdColumn("ROLE_ID");
        param.setRoleFunctionTableFunctionIdColumn("FUNCTION_KEY");
        param.setRoleFunctionTableInsertUserIdColumn("INSERT_USER");
        param.setRoleFunctionTableInsertDateTimeColumn("INSERT_DATETIME");
        param.setRoleFunctionTableUpdateUserIdColumn("UPDATE_USER");
        param.setRoleFunctionTableUpdateDateTimeColumn("UPDATE_DATETIME");

        SerializeUtils.writeObject(param, new FileOutputStream(out));

        System.out.println("finish.  [" + out.getAbsolutePath() + "]");

        System.out.println("");

        System.out.println("select menu.");
        menuselect();

    }

}
