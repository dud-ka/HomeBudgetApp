SELECT tab.date, tab.description, receipt_details.amount, receipt_details.category
FROM receipt_details
inner JOIN
    (SELECT bill.description, bill.date, bill.user_id, bill.id
     FROM bill
    WHERE bill.user_id = 2)

        as tab ON tab.id = receipt_details.receipt_id;