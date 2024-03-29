SELECT a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, SUM(b.PRICE * bs.SALES) AS 'TOTAL_SALES'
FROM BOOK b
INNER JOIN AUTHOR a ON b.AUTHOR_ID = a.AUTHOR_ID
INNER JOIN BOOK_SALES bs ON b.BOOK_ID = bs.BOOK_ID
WHERE bs.SALES_DATE BETWEEN '2022-01-01' AND '2022-01-31'
GROUP BY a.AUTHOR_NAME, b.CATEGORY
ORDER BY AUTHOR_ID, CATEGORY DESC;