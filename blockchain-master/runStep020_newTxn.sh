
echo "------------- Add New Transaction on  Node 1 -----------------"

curl -X POST -H "Content-Type: application/json" -d '{
 "sender": "d4ee26eee15148ee92c6cd394edd974e",
 "recipient": "someone-other-address",
 "amount": 5
}' "http://localhost:5000/transactions/new"

echo "------------- Add One more New Transaction on  Node 1 -----------------"

curl -X POST -H "Content-Type: application/json" -d '{
 "sender": "d4ee26eee15148ee92c6cd394edd974e",
 "recipient": "someone-other-address",
 "amount": 235
}' "http://localhost:5000/transactions/new"

echo "------------- Add One more New Transaction on  Node 1 -----------------"

curl -X POST -H "Content-Type: application/json" -d '{
 "sender": "d4ee26eee15148ee92c6cd394edd974e",
 "recipient": "someone-other-address",
 "amount": 786 
}' "http://localhost:5000/transactions/new"
