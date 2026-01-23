-- 코드를 입력하세요
SELECT FLAVOR
from FIRST_HALF
group by FLAVOR
order by TOTAL_ORDER desc, SHIPMENT_ID asc