

#------- ON TERMINAL 2  -------
cd
cd /user1/snBlockChain/snBlockChain/blockchain-master

#pipenv --python=python3.6
#pipenv install
#pipenv run python blockchain.py --port 5001

dt=`date +"%Y%m%d_%H%M%S"`
echo $dt
pipenv run python blockchain.py -p 5002 > /user1/snBlockChain/snBlockChain/logs/runNode3_${dt}.log  2>&1  & 
if [ "S$1N" == "SN" ]
then
  tail -100f  /user1/snBlockChain/snBlockChain/logs/runNode3_${dt}.log
fi





