@echo off
setlocal

git pull 
git fetch 

git add *.*

git commit -m "Added new files"
git push 


endlocal
