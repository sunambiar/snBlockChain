

#---------- ON TERMINAL 1 ------
echo "------ This Requires internet connection -------"
cd
cd /user1/snBlockChain/snBlockChain/blockchain-master

#rm -rf /root/.local/share/virtualenvs/blockchain-master-* 
rm -rf ~/.local/share/virtualenvs/snBlockChain/blockchain-master* 
#pipenv --python=python3.6
pipenv --python=python3.6 --site-packages lock 
cat Pipfile
pipenv --python=python3.6 --site-packages install
#pipenv --site-packages install
#pipenv shell 
#pip install Flask requests  

#pip install Flask==0.12.2 requests==2.18.4  
#cat Pipfile


#pipenv install requests flask
#pipenv install '/user1/snBlockChain/snBlockChain/blockchain-master'
#pipenv install '-e .'





