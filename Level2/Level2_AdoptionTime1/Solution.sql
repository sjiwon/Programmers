SELECT HOUR(DATETIME) AS HOUR, COUNT(DATETIME) AS COUNT
FROM ANIMAL_OUTS
GROUP BY HOUR
HAVING HOUR >= 9 AND HOUR <= 20
ORDER BY HOUR;

-- HOUR = DATETIME에서 시간 추출 함수