-- write your code in PostgreSQL 9.4
-- @return a list of accounts, accounts that have at least 1024 USD at most 3 transfers
-- Smith -> John,512
-- Will -> John, 100
-- Will -> John, 10
-- Brown -> John, 500
-- total = 512+100+10+500 = 1122, top three = 512+100+10 = 1112 > 1024

-- need to find recipients who receive top 3 > 1024



SELECT recipient FROM
(
    SELECT recipient,sum(amount) AS total FROM
    (
        SELECT recipient,amount FROM
        (
            SELECT *, ROW_NUMBER() OVER (PARTITION BY
            recipient order by amount DESC) AS row_id FROM transfers
        ) a
        WHERE row_id < 4 ORDER BY recipient
    ) b
    GROUP BY recipient
) c
WHERE total >= 1024;
