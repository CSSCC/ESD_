# ESD_
Assignment for E.S.D 

RegistrationController 
- Convert name (retrived from index(registration page)) into username
- Convert date (retrived from index(registration page)) into password
- Set dor to current time and date

Members page 
   Payment/balance 
   - Display the balance for current user
   - Allow Payment to be made, only if their balance needs paying off
   Submit a claim
   - Add a claim form
   - Send claim form through a servlet (similar to registrationController) to database 
   History of payments/claims
   - Show history of payments and claims for current user
   
Admin page
   - List all members ✓
   - List oustanding balances ✓
   - List claims ✓
   List provisional member applications (havent paid membership)
   - List the members who status is APPLIED
   Process upgrade when payment made
   - Update status to APPROVED from PAID if payment made
   Suspend/resume membership
   - ?
   Report annual turnover


How to Git

1.	Open Git Cmd

2.	Cd into file where you want to clone repository
   (Only do this when needing full repo. I.e - restart/deleting)

3.	Type "git clone https://github.com/CSSCC/ESD_"

4.	git pull (gets most recent version of everything)

5.	Make changes to the project

6.	git status (check changes)

7.	git add 

8. git status (checks add)

9.	git commit –m “**NOTE WHAT YOU CHANGED**”

9.	git push (pushes it to repository)
