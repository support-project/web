SELECT * FROM SYSTEM_CONFIGS
WHERE DELETE_FLAG = 0
ORDER BY INSERT_DATETIME DESC
LIMIT ? OFFSET ?;
