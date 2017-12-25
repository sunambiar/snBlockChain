

#---------- ON TERMINAL 1 ------
cd
cd /user1/snBlockChain/snBlockChain/blockchain-master

#rm -rf /Users/sureshnambiar/.local/share/virtualenvs/blockchain-master-* 
#pipenv --python=python3.6
#pipenv install
dt=`date +"%Y%m%d_%H%M%S"`
echo $dt


#pipenv shell
#pip install Flask requests
#cat Pipfile

#python blockchain.py -p 5000 > /user1/snBlockChain/snBlockChain/logs/runNode1_${dt}.log  2>&1 
#pipenv shell 
#python blockchain.py -p 5000 > /user1/snBlockChain/snBlockChain/logs/runNode1_${dt}.log  2>&1 &  

pipenv run python blockchain.py -p 5000 > /user1/snBlockChain/snBlockChain/logs/runNode1_${dt}.log  2>&1  &
if [ "S$1N" == "SN" ]
then
  tail -100f  /user1/snBlockChain/snBlockChain/logs/runNode1_${dt}.log
fi 




