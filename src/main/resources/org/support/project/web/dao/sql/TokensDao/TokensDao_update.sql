UPDATE TOKENS
SET 
   USER_ID = ?
 , EXPIRES = ?
 , TOKEN_TYPE = ?
 , ROW_ID = ?
 , INSERT_USER = ?
 , INSERT_DATETIME = ?
 , UPDATE_USER = ?
 , UPDATE_DATETIME = ?
 , DELETE_FLAG = ?
WHERE 
TOKEN = ?
;
