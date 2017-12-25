
echo "------------- Register Node 2 on Node 1  -----------------"

curl -X POST -H "Content-Type: application/json" -d '{
  "nodes": ["http://localhost:5001"]
}' "http://localhost:5000/nodes/register"


