# Write your MySQL query statement below
SELECT t.request_at AS Day, ROUND(SUM(t.status IN ('cancelled_by_driver', 'cancelled_by_client')) / COUNT(*),2
) AS `Cancellation Rate`
FROM
Trips t LEFT JOIN Users c
ON t.client_id=c.users_id 
LEFT JOIN Users d
ON t.driver_id=d.users_id 
WHERE t.request_at BETWEEN '2013-10-01' AND '2013-10-03' AND c.banned="No" AND d.banned='No'
GROUP BY t.request_at;