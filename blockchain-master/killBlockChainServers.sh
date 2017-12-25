#-------------- Kill all the Blockchain services that are running ------------- SuN --- 2017-12-25 ---
for i in `ps -ef | grep python | grep -v grep | grep blockchain.py | awk '{print $2}' `
do
  echo "Killing... PID $i"
  kill -9 $i
done

