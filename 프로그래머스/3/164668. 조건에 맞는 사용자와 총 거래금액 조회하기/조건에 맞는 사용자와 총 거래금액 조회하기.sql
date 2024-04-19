SELECT U.USER_ID, U.NICKNAME, SUM(PRICE) AS TOTAL_SALES
FROM USED_GOODS_BOARD
JOIN USED_GOODS_USER AS U ON WRITER_ID = U.USER_ID
WHERE STATUS = 'DONE'
GROUP BY WRITER_ID HAVING SUM(PRICE) >= 700000
ORDER BY TOTAL_SALES