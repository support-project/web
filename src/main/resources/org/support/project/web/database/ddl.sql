-- LDAP認証設定
drop table if exists LDAP_CONFIGS cascade;

create table LDAP_CONFIGS (
  SYSTEM_NAME character varying(64) not null
  , HOST character varying(256) not null
  , PORT integer not null
  , USE_SSL integer
  , USE_TLS integer
  , BIND_DN character varying(256)
  , BIND_PASSWORD character varying(1048)
  , SALT character varying(1048)
  , BASE_DN character varying(256) not null
  , FILTER character varying(256)
  , ID_ATTR character varying(256) not null
  , NAME_ATTR character varying(256)
  , MAIL_ATTR character varying(256)
  , ADMIN_CHECK_FILTER character varying(256)
  , AUTH_TYPE integer not null
  , ROW_ID character varying(64)
  , INSERT_USER integer
  , INSERT_DATETIME timestamp
  , UPDATE_USER integer
  , UPDATE_DATETIME timestamp
  , DELETE_FLAG integer
  , constraint LDAP_CONFIGS_PKC primary key (SYSTEM_NAME)
) ;

-- メールアドレス変更確認
drop table if exists CONFIRM_MAIL_CHANGES cascade;

create table CONFIRM_MAIL_CHANGES (
  ID character varying(256) not null
  , USER_ID integer not null
  , MAIL_ADDRESS character varying(256) not null
  , ROW_ID character varying(64)
  , INSERT_USER integer
  , INSERT_DATETIME timestamp
  , UPDATE_USER integer
  , UPDATE_DATETIME timestamp
  , DELETE_FLAG integer
  , constraint CONFIRM_MAIL_CHANGES_PKC primary key (ID)
) ;

-- ロケール
drop table if exists LOCALES cascade;

create table LOCALES (
  KEY character varying(12) not null
  , LANGUAGE character varying(4)
  , COUNTRY character varying(4)
  , Variant character varying(4)
  , ROW_ID character varying(64)
  , INSERT_USER integer
  , INSERT_DATETIME timestamp
  , UPDATE_USER integer
  , UPDATE_DATETIME timestamp
  , DELETE_FLAG integer
  , constraint LOCALES_PKC primary key (KEY)
) ;

-- パスワードリセット
drop table if exists PASSWORD_RESETS cascade;

create table PASSWORD_RESETS (
  ID character varying(256) not null
  , USER_KEY character varying(256)
  , ROW_ID character varying(64)
  , INSERT_USER integer
  , INSERT_DATETIME timestamp
  , UPDATE_USER integer
  , UPDATE_DATETIME timestamp
  , DELETE_FLAG integer
  , constraint PASSWORD_RESETS_PKC primary key (ID)
) ;

-- 仮登録ユーザ
drop table if exists PROVISIONAL_REGISTRATIONS cascade;

create table PROVISIONAL_REGISTRATIONS (
  ID character varying(256) not null
  , USER_KEY character varying(256) not null
  , USER_NAME character varying(256) not null
  , PASSWORD character varying(1024) not null
  , SALT character varying(1024) not null
  , LOCALE_KEY character varying(12)
  , MAIL_ADDRESS character varying(256)
  , ROW_ID character varying(64)
  , INSERT_USER integer
  , INSERT_DATETIME timestamp
  , UPDATE_USER integer
  , UPDATE_DATETIME timestamp
  , DELETE_FLAG integer
  , constraint PROVISIONAL_REGISTRATIONS_PKC primary key (ID)
) ;

-- ハッシュ生成の設定
drop table if exists HASH_CONFIGS cascade;

create table HASH_CONFIGS (
  SYSTEM_NAME character varying(64) not null
  , HASH_ITERATIONS integer not null
  , HASH_SIZE_BITS integer not null
  , ROW_ID character varying(64)
  , INSERT_USER integer
  , INSERT_DATETIME timestamp
  , UPDATE_USER integer
  , UPDATE_DATETIME timestamp
  , DELETE_FLAG integer
  , constraint HASH_CONFIGS_PKC primary key (SYSTEM_NAME)
) ;

-- メール設定
drop table if exists MAIL_CONFIGS cascade;

create table MAIL_CONFIGS (
  SYSTEM_NAME character varying(64) not null
  , HOST character varying(256) not null
  , PORT integer not null
  , AUTH_TYPE integer not null
  , SMTP_ID character varying(256)
  , SMTP_PASSWORD character varying(1048)
  , SALT character varying(1048)
  , FROM_ADDRESS character varying(256)
  , FROM_NAME character varying(256)
  , ROW_ID character varying(64)
  , INSERT_USER integer
  , INSERT_DATETIME timestamp
  , UPDATE_USER integer
  , UPDATE_DATETIME timestamp
  , DELETE_FLAG integer
  , constraint MAIL_CONFIGS_PKC primary key (SYSTEM_NAME)
) ;

-- コンフィグ
drop table if exists SYSTEM_CONFIGS cascade;

create table SYSTEM_CONFIGS (
  SYSTEM_NAME character varying(64) not null
  , CONFIG_NAME character varying(256) not null
  , CONFIG_VALUE character varying(1024)
  , ROW_ID character varying(64)
  , INSERT_USER integer
  , INSERT_DATETIME timestamp
  , UPDATE_USER integer
  , UPDATE_DATETIME timestamp
  , DELETE_FLAG integer
  , constraint SYSTEM_CONFIGS_PKC primary key (SYSTEM_NAME,CONFIG_NAME)
) ;

-- メール
drop table if exists MAILS cascade;

create table MAILS (
  MAIL_ID character varying(64) not null
  , STATUS integer not null
  , TO_ADDRESS character varying(256) not null
  , TO_NAME character varying(256)
  , FROM_ADDRESS character varying(256)
  , FROM_NAME character varying(256)
  , TITLE character varying(256) not null
  , CONTENT text
  , ROW_ID character varying(64)
  , INSERT_USER integer
  , INSERT_DATETIME timestamp
  , UPDATE_USER integer
  , UPDATE_DATETIME timestamp
  , DELETE_FLAG integer
  , constraint MAILS_PKC primary key (MAIL_ID)
) ;

create index IDX_MAILS_STATUS
  on MAILS(STATUS);

-- ACCESS_LOGS
drop table if exists ACCESS_LOGS cascade;

create table ACCESS_LOGS (
  NO BIGSERIAL not null
  , PATH character varying(1024)
  , IP_ADDRESS character varying(64)
  , USER_AGENT character varying(1024)
  , ROW_ID character varying(64)
  , INSERT_USER integer
  , INSERT_DATETIME timestamp
  , UPDATE_USER integer
  , UPDATE_DATETIME timestamp
  , DELETE_FLAG integer
  , constraint ACCESS_LOGS_PKC primary key (NO)
) ;

-- システムの設定
drop table if exists SYSTEMS cascade;

create table SYSTEMS (
  SYSTEM_NAME character varying(64) not null
  , VERSION character varying(16) not null
  , ROW_ID character varying(64)
  , INSERT_USER integer
  , INSERT_DATETIME timestamp
  , UPDATE_USER integer
  , UPDATE_DATETIME timestamp
  , DELETE_FLAG integer
  , constraint SYSTEMS_PKC primary key (SYSTEM_NAME)
) ;

-- ユーザが所属するグループ
drop table if exists USER_GROUPS cascade;

create table USER_GROUPS (
  USER_ID integer not null
  , GROUP_ID integer not null
  , GROUP_ROLE integer
  , ROW_ID character varying(64)
  , INSERT_USER integer
  , INSERT_DATETIME timestamp
  , UPDATE_USER integer
  , UPDATE_DATETIME timestamp
  , DELETE_FLAG integer
  , constraint USER_GROUPS_PKC primary key (USER_ID,GROUP_ID)
) ;

-- グループ
drop table if exists GROUPS cascade;

create table GROUPS (
  GROUP_ID SERIAL not null
  , GROUP_KEY character varying(68) not null
  , GROUP_NAME character varying(128) not null
  , DESCRIPTION character varying(256)
  , PARENT_GROUP_KEY character varying(128)
  , GROUP_CLASS integer
  , ROW_ID character varying(64)
  , INSERT_USER integer
  , INSERT_DATETIME timestamp
  , UPDATE_USER integer
  , UPDATE_DATETIME timestamp
  , DELETE_FLAG integer
  , constraint GROUPS_PKC primary key (GROUP_ID)
) ;

-- ユーザ
drop table if exists USERS cascade;

create table USERS (
  USER_ID SERIAL not null
  , USER_KEY character varying(256) not null
  , USER_NAME character varying(256) not null
  , PASSWORD character varying(1024) not null
  , SALT character varying(1024)
  , LOCALE_KEY character varying(12)
  , MAIL_ADDRESS character varying(256)
  , AUTH_LDAP integer
  , ROW_ID character varying(64)
  , INSERT_USER integer
  , INSERT_DATETIME timestamp
  , UPDATE_USER integer
  , UPDATE_DATETIME timestamp
  , DELETE_FLAG integer
  , constraint USERS_PKC primary key (USER_ID)
) ;

create unique index IDX_USERS_USER_KEY
  on USERS(USER_KEY);

-- 権限
drop table if exists ROLES cascade;

create table ROLES (
  ROLE_ID SERIAL not null
  , ROLE_KEY character varying(12) not null
  , ROLE_NAME character varying(50)
  , ROW_ID character varying(64)
  , INSERT_USER integer
  , INSERT_DATETIME timestamp
  , UPDATE_USER integer
  , UPDATE_DATETIME timestamp
  , DELETE_FLAG integer
  , constraint ROLES_PKC primary key (ROLE_ID)
) ;

-- ユーザの権限
drop table if exists USER_ROLES cascade;

create table USER_ROLES (
  USER_ID integer not null
  , ROLE_ID integer not null
  , ROW_ID character varying(64)
  , INSERT_USER integer
  , INSERT_DATETIME timestamp
  , UPDATE_USER integer
  , UPDATE_DATETIME timestamp
  , DELETE_FLAG integer
  , constraint USER_ROLES_PKC primary key (USER_ID,ROLE_ID)
) ;

-- ログイン履歴
drop table if exists LOGIN_HISTORIES cascade;

create table LOGIN_HISTORIES (
  USER_ID integer not null
  , LOGIN_COUNT double precision not null
  , LODIN_DATE_TIME timestamp not null
  , IP_ADDRESS character varying(15)
  , USER_AGENT character varying(256)
  , ROW_ID character varying(64)
  , INSERT_USER integer
  , INSERT_DATETIME timestamp
  , UPDATE_USER integer
  , UPDATE_DATETIME timestamp
  , DELETE_FLAG integer
  , constraint LOGIN_HISTORIES_PKC primary key (USER_ID,LOGIN_COUNT)
) ;

-- 機能
drop table if exists FUNCTIONS cascade;

create table FUNCTIONS (
  FUNCTION_KEY character varying(64) not null
  , DESCRIPTION character varying(256)
  , ROW_ID character varying(64)
  , INSERT_USER integer
  , INSERT_DATETIME timestamp
  , UPDATE_USER integer
  , UPDATE_DATETIME timestamp
  , DELETE_FLAG integer
  , constraint FUNCTIONS_PKC primary key (FUNCTION_KEY)
) ;

-- 機能にアクセスできる権限
drop table if exists ROLE_FUNCTIONS cascade;

create table ROLE_FUNCTIONS (
  ROLE_ID integer not null
  , FUNCTION_KEY character varying(64) not null
  , ROW_ID character varying(64)
  , INSERT_USER integer
  , INSERT_DATETIME timestamp
  , UPDATE_USER integer
  , UPDATE_DATETIME timestamp
  , DELETE_FLAG integer
  , constraint ROLE_FUNCTIONS_PKC primary key (ROLE_ID,FUNCTION_KEY)
) ;

comment on table LDAP_CONFIGS is 'LDAP認証設定';
comment on column LDAP_CONFIGS.SYSTEM_NAME is 'システム名';
comment on column LDAP_CONFIGS.HOST is 'HOST';
comment on column LDAP_CONFIGS.PORT is 'PORT';
comment on column LDAP_CONFIGS.USE_SSL is 'USE_SSL';
comment on column LDAP_CONFIGS.USE_TLS is 'USE_TLS';
comment on column LDAP_CONFIGS.BIND_DN is 'BIND_DN';
comment on column LDAP_CONFIGS.BIND_PASSWORD is 'BIND_PASSWORD';
comment on column LDAP_CONFIGS.SALT is 'SALT';
comment on column LDAP_CONFIGS.BASE_DN is 'BASE_DN';
comment on column LDAP_CONFIGS.FILTER is 'FILTER';
comment on column LDAP_CONFIGS.ID_ATTR is 'ID_ATTR';
comment on column LDAP_CONFIGS.NAME_ATTR is 'NAME_ATTR';
comment on column LDAP_CONFIGS.MAIL_ATTR is 'MAIL_ATTR';
comment on column LDAP_CONFIGS.ADMIN_CHECK_FILTER is 'ADMIN_CHECK_FILTER';
comment on column LDAP_CONFIGS.AUTH_TYPE is 'AUTH_TYPE	 0:DB認証,1:LDAP認証,2:DB認証+LDAP認証(LDAP優先)';
comment on column LDAP_CONFIGS.ROW_ID is '行ID';
comment on column LDAP_CONFIGS.INSERT_USER is '登録ユーザ';
comment on column LDAP_CONFIGS.INSERT_DATETIME is '登録日時';
comment on column LDAP_CONFIGS.UPDATE_USER is '更新ユーザ';
comment on column LDAP_CONFIGS.UPDATE_DATETIME is '更新日時';
comment on column LDAP_CONFIGS.DELETE_FLAG is '削除フラグ';

comment on table CONFIRM_MAIL_CHANGES is 'メールアドレス変更確認';
comment on column CONFIRM_MAIL_CHANGES.ID is 'リセット用ID';
comment on column CONFIRM_MAIL_CHANGES.USER_ID is 'ユーザID';
comment on column CONFIRM_MAIL_CHANGES.MAIL_ADDRESS is 'メールアドレス';
comment on column CONFIRM_MAIL_CHANGES.ROW_ID is '行ID';
comment on column CONFIRM_MAIL_CHANGES.INSERT_USER is '登録ユーザ';
comment on column CONFIRM_MAIL_CHANGES.INSERT_DATETIME is '登録日時';
comment on column CONFIRM_MAIL_CHANGES.UPDATE_USER is '更新ユーザ';
comment on column CONFIRM_MAIL_CHANGES.UPDATE_DATETIME is '更新日時';
comment on column CONFIRM_MAIL_CHANGES.DELETE_FLAG is '削除フラグ';

comment on table LOCALES is 'ロケール';
comment on column LOCALES.KEY is 'キー';
comment on column LOCALES.LANGUAGE is '言語';
comment on column LOCALES.COUNTRY is '国';
comment on column LOCALES.Variant is 'バリアント';
comment on column LOCALES.ROW_ID is '行ID';
comment on column LOCALES.INSERT_USER is '登録ユーザ';
comment on column LOCALES.INSERT_DATETIME is '登録日時';
comment on column LOCALES.UPDATE_USER is '更新ユーザ';
comment on column LOCALES.UPDATE_DATETIME is '更新日時';
comment on column LOCALES.DELETE_FLAG is '削除フラグ';

comment on table PASSWORD_RESETS is 'パスワードリセット';
comment on column PASSWORD_RESETS.ID is 'パスワードリセットID';
comment on column PASSWORD_RESETS.USER_KEY is 'ユーザKEY';
comment on column PASSWORD_RESETS.ROW_ID is '行ID';
comment on column PASSWORD_RESETS.INSERT_USER is '登録ユーザ';
comment on column PASSWORD_RESETS.INSERT_DATETIME is '登録日時';
comment on column PASSWORD_RESETS.UPDATE_USER is '更新ユーザ';
comment on column PASSWORD_RESETS.UPDATE_DATETIME is '更新日時';
comment on column PASSWORD_RESETS.DELETE_FLAG is '削除フラグ';

comment on table PROVISIONAL_REGISTRATIONS is '仮登録ユーザ';
comment on column PROVISIONAL_REGISTRATIONS.ID is '仮発行ID';
comment on column PROVISIONAL_REGISTRATIONS.USER_KEY is 'ユーザKEY';
comment on column PROVISIONAL_REGISTRATIONS.USER_NAME is 'ユーザ名';
comment on column PROVISIONAL_REGISTRATIONS.PASSWORD is 'パスワード';
comment on column PROVISIONAL_REGISTRATIONS.SALT is 'SALT';
comment on column PROVISIONAL_REGISTRATIONS.LOCALE_KEY is 'ロケール';
comment on column PROVISIONAL_REGISTRATIONS.MAIL_ADDRESS is 'メールアドレス';
comment on column PROVISIONAL_REGISTRATIONS.ROW_ID is '行ID';
comment on column PROVISIONAL_REGISTRATIONS.INSERT_USER is '登録ユーザ';
comment on column PROVISIONAL_REGISTRATIONS.INSERT_DATETIME is '登録日時';
comment on column PROVISIONAL_REGISTRATIONS.UPDATE_USER is '更新ユーザ';
comment on column PROVISIONAL_REGISTRATIONS.UPDATE_DATETIME is '更新日時';
comment on column PROVISIONAL_REGISTRATIONS.DELETE_FLAG is '削除フラグ';

comment on table HASH_CONFIGS is 'ハッシュ生成の設定';
comment on column HASH_CONFIGS.SYSTEM_NAME is 'システム名';
comment on column HASH_CONFIGS.HASH_ITERATIONS is 'HASH_ITERATIONS';
comment on column HASH_CONFIGS.HASH_SIZE_BITS is 'HASH_SIZE_BITS';
comment on column HASH_CONFIGS.ROW_ID is '行ID';
comment on column HASH_CONFIGS.INSERT_USER is '登録ユーザ';
comment on column HASH_CONFIGS.INSERT_DATETIME is '登録日時';
comment on column HASH_CONFIGS.UPDATE_USER is '更新ユーザ';
comment on column HASH_CONFIGS.UPDATE_DATETIME is '更新日時';
comment on column HASH_CONFIGS.DELETE_FLAG is '削除フラグ';

comment on table MAIL_CONFIGS is 'メール設定';
comment on column MAIL_CONFIGS.SYSTEM_NAME is 'システム名';
comment on column MAIL_CONFIGS.HOST is 'SMTP_HOST';
comment on column MAIL_CONFIGS.PORT is 'SMTP_PORT';
comment on column MAIL_CONFIGS.AUTH_TYPE is 'AUTH_TYPE';
comment on column MAIL_CONFIGS.SMTP_ID is 'SMTP_ID';
comment on column MAIL_CONFIGS.SMTP_PASSWORD is 'SMTP_PASSWORD	 暗号化（可逆）';
comment on column MAIL_CONFIGS.SALT is 'SALT';
comment on column MAIL_CONFIGS.FROM_ADDRESS is '送信元';
comment on column MAIL_CONFIGS.FROM_NAME is '送信元名';
comment on column MAIL_CONFIGS.ROW_ID is '行ID';
comment on column MAIL_CONFIGS.INSERT_USER is '登録ユーザ';
comment on column MAIL_CONFIGS.INSERT_DATETIME is '登録日時';
comment on column MAIL_CONFIGS.UPDATE_USER is '更新ユーザ';
comment on column MAIL_CONFIGS.UPDATE_DATETIME is '更新日時';
comment on column MAIL_CONFIGS.DELETE_FLAG is '削除フラグ';

comment on table SYSTEM_CONFIGS is 'コンフィグ';
comment on column SYSTEM_CONFIGS.SYSTEM_NAME is 'システム名';
comment on column SYSTEM_CONFIGS.CONFIG_NAME is 'コンフィグ名';
comment on column SYSTEM_CONFIGS.CONFIG_VALUE is 'コンフィグ値';
comment on column SYSTEM_CONFIGS.ROW_ID is '行ID';
comment on column SYSTEM_CONFIGS.INSERT_USER is '登録ユーザ';
comment on column SYSTEM_CONFIGS.INSERT_DATETIME is '登録日時';
comment on column SYSTEM_CONFIGS.UPDATE_USER is '更新ユーザ';
comment on column SYSTEM_CONFIGS.UPDATE_DATETIME is '更新日時';
comment on column SYSTEM_CONFIGS.DELETE_FLAG is '削除フラグ';

comment on table MAILS is 'メール';
comment on column MAILS.MAIL_ID is 'MAIL_ID';
comment on column MAILS.STATUS is 'ステータス';
comment on column MAILS.TO_ADDRESS is '送信先';
comment on column MAILS.TO_NAME is '送信先名';
comment on column MAILS.FROM_ADDRESS is '送信元';
comment on column MAILS.FROM_NAME is '送信元名';
comment on column MAILS.TITLE is 'タイトル';
comment on column MAILS.CONTENT is 'メッセージ';
comment on column MAILS.ROW_ID is '行ID';
comment on column MAILS.INSERT_USER is '登録ユーザ';
comment on column MAILS.INSERT_DATETIME is '登録日時';
comment on column MAILS.UPDATE_USER is '更新ユーザ';
comment on column MAILS.UPDATE_DATETIME is '更新日時';
comment on column MAILS.DELETE_FLAG is '削除フラグ';

comment on table ACCESS_LOGS is 'ACCESS_LOGS';
comment on column ACCESS_LOGS.NO is 'NO';
comment on column ACCESS_LOGS.PATH is 'PATH';
comment on column ACCESS_LOGS.IP_ADDRESS is 'IP_ADDRESS';
comment on column ACCESS_LOGS.USER_AGENT is 'USER_AGENT';
comment on column ACCESS_LOGS.ROW_ID is '行ID';
comment on column ACCESS_LOGS.INSERT_USER is '登録ユーザ';
comment on column ACCESS_LOGS.INSERT_DATETIME is '登録日時';
comment on column ACCESS_LOGS.UPDATE_USER is '更新ユーザ';
comment on column ACCESS_LOGS.UPDATE_DATETIME is '更新日時';
comment on column ACCESS_LOGS.DELETE_FLAG is '削除フラグ';

comment on table SYSTEMS is 'システムの設定';
comment on column SYSTEMS.SYSTEM_NAME is 'システム名';
comment on column SYSTEMS.VERSION is 'バージョン';
comment on column SYSTEMS.ROW_ID is '行ID';
comment on column SYSTEMS.INSERT_USER is '登録ユーザ';
comment on column SYSTEMS.INSERT_DATETIME is '登録日時';
comment on column SYSTEMS.UPDATE_USER is '更新ユーザ';
comment on column SYSTEMS.UPDATE_DATETIME is '更新日時';
comment on column SYSTEMS.DELETE_FLAG is '削除フラグ';

comment on table USER_GROUPS is 'ユーザが所属するグループ';
comment on column USER_GROUPS.USER_ID is 'ユーザID';
comment on column USER_GROUPS.GROUP_ID is 'グループID	 CHARACTER SET latin1';
comment on column USER_GROUPS.GROUP_ROLE is 'グループの権限';
comment on column USER_GROUPS.ROW_ID is '行ID';
comment on column USER_GROUPS.INSERT_USER is '登録ユーザ';
comment on column USER_GROUPS.INSERT_DATETIME is '登録日時';
comment on column USER_GROUPS.UPDATE_USER is '更新ユーザ';
comment on column USER_GROUPS.UPDATE_DATETIME is '更新日時';
comment on column USER_GROUPS.DELETE_FLAG is '削除フラグ';

comment on table GROUPS is 'グループ';
comment on column GROUPS.GROUP_ID is 'グループID';
comment on column GROUPS.GROUP_KEY is 'グループKEY';
comment on column GROUPS.GROUP_NAME is 'グループ名称';
comment on column GROUPS.DESCRIPTION is '説明';
comment on column GROUPS.PARENT_GROUP_KEY is '親グループKKEY';
comment on column GROUPS.GROUP_CLASS is 'グループの区分';
comment on column GROUPS.ROW_ID is '行ID';
comment on column GROUPS.INSERT_USER is '登録ユーザ';
comment on column GROUPS.INSERT_DATETIME is '登録日時';
comment on column GROUPS.UPDATE_USER is '更新ユーザ';
comment on column GROUPS.UPDATE_DATETIME is '更新日時';
comment on column GROUPS.DELETE_FLAG is '削除フラグ';

comment on table USERS is 'ユーザ';
comment on column USERS.USER_ID is 'ユーザID';
comment on column USERS.USER_KEY is 'ユーザKEY	 ユニーク';
comment on column USERS.USER_NAME is 'ユーザ名';
comment on column USERS.PASSWORD is 'パスワード	 ハッシュ(不可逆)';
comment on column USERS.SALT is 'SALT';
comment on column USERS.LOCALE_KEY is 'ロケール';
comment on column USERS.MAIL_ADDRESS is 'メールアドレス';
comment on column USERS.AUTH_LDAP is 'LDAP認証ユーザかどうか';
comment on column USERS.ROW_ID is '行ID';
comment on column USERS.INSERT_USER is '登録ユーザ';
comment on column USERS.INSERT_DATETIME is '登録日時';
comment on column USERS.UPDATE_USER is '更新ユーザ';
comment on column USERS.UPDATE_DATETIME is '更新日時';
comment on column USERS.DELETE_FLAG is '削除フラグ';

comment on table ROLES is '権限';
comment on column ROLES.ROLE_ID is '権限ID';
comment on column ROLES.ROLE_KEY is '権限KEY';
comment on column ROLES.ROLE_NAME is '権限名';
comment on column ROLES.ROW_ID is '行ID';
comment on column ROLES.INSERT_USER is '登録ユーザ';
comment on column ROLES.INSERT_DATETIME is '登録日時';
comment on column ROLES.UPDATE_USER is '更新ユーザ';
comment on column ROLES.UPDATE_DATETIME is '更新日時';
comment on column ROLES.DELETE_FLAG is '削除フラグ';

comment on table USER_ROLES is 'ユーザの権限';
comment on column USER_ROLES.USER_ID is 'ユーザID';
comment on column USER_ROLES.ROLE_ID is '権限ID';
comment on column USER_ROLES.ROW_ID is '行ID';
comment on column USER_ROLES.INSERT_USER is '登録ユーザ';
comment on column USER_ROLES.INSERT_DATETIME is '登録日時';
comment on column USER_ROLES.UPDATE_USER is '更新ユーザ';
comment on column USER_ROLES.UPDATE_DATETIME is '更新日時';
comment on column USER_ROLES.DELETE_FLAG is '削除フラグ';

comment on table LOGIN_HISTORIES is 'ログイン履歴';
comment on column LOGIN_HISTORIES.USER_ID is 'ユーザID';
comment on column LOGIN_HISTORIES.LOGIN_COUNT is 'ログイン番号';
comment on column LOGIN_HISTORIES.LODIN_DATE_TIME is 'ログイン日時';
comment on column LOGIN_HISTORIES.IP_ADDRESS is 'IPアドレス';
comment on column LOGIN_HISTORIES.USER_AGENT is 'エージェント';
comment on column LOGIN_HISTORIES.ROW_ID is '行ID';
comment on column LOGIN_HISTORIES.INSERT_USER is '登録ユーザ';
comment on column LOGIN_HISTORIES.INSERT_DATETIME is '登録日時';
comment on column LOGIN_HISTORIES.UPDATE_USER is '更新ユーザ';
comment on column LOGIN_HISTORIES.UPDATE_DATETIME is '更新日時';
comment on column LOGIN_HISTORIES.DELETE_FLAG is '削除フラグ';

comment on table FUNCTIONS is '機能';
comment on column FUNCTIONS.FUNCTION_KEY is '機能';
comment on column FUNCTIONS.DESCRIPTION is '機能の説明';
comment on column FUNCTIONS.ROW_ID is '行ID';
comment on column FUNCTIONS.INSERT_USER is '登録ユーザ';
comment on column FUNCTIONS.INSERT_DATETIME is '登録日時';
comment on column FUNCTIONS.UPDATE_USER is '更新ユーザ';
comment on column FUNCTIONS.UPDATE_DATETIME is '更新日時';
comment on column FUNCTIONS.DELETE_FLAG is '削除フラグ';

comment on table ROLE_FUNCTIONS is '機能にアクセスできる権限';
comment on column ROLE_FUNCTIONS.ROLE_ID is '権限ID';
comment on column ROLE_FUNCTIONS.FUNCTION_KEY is '機能';
comment on column ROLE_FUNCTIONS.ROW_ID is '行ID';
comment on column ROLE_FUNCTIONS.INSERT_USER is '登録ユーザ';
comment on column ROLE_FUNCTIONS.INSERT_DATETIME is '登録日時';
comment on column ROLE_FUNCTIONS.UPDATE_USER is '更新ユーザ';
comment on column ROLE_FUNCTIONS.UPDATE_DATETIME is '更新日時';
comment on column ROLE_FUNCTIONS.DELETE_FLAG is '削除フラグ';
