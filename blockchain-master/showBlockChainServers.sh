#-------------- Kill all the Blockchain services that are running ------------- SuN --- 2017-12-25 ---
echo "############################################################################"
ps -ef | grep python | grep -v grep | grep blockchain.py 
echo "############################################################################"

