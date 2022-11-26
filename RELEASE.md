# **Release Notes**
## Release-1.4
### 26/11/2022
### Bug Fix
- Fixed bug where after entering a valid expression after an invalid one, the ouptut will be incorrect or throw an error.
For example:
<pre>
    Expression 1: 10 10 gives an error
    Expression 2: 5 5 + Outputs an error or outputs 15
</pre>

<br />

## Release-1.3
### 25/11/2022
### Bug Fix
- Fixed bug for a special case where when a user types **10 10** as an expression it would not output an invalid expression. This is because there was no operators in this expression, to perform an evaluation.

<br />

## Release-1.2
### 25/11/2022
### Bug Fix
- Fixed bug where error message was not being output to screen when an invalid expression had been enterd.
- Fixed bug where error message was not being outputed when unrecognisable operator was detected.

<br />

## Release-1.1 
### 24/11/2022
### New
- Font size has increased to make numbers easy to read.
- Application is not resizable anymore to prevent components from overlapping one another.
- Postfix and Infix radio buttons have been deleted as the calculator can **only** perform postfix calculations. 

<br />

## Release-1.0 
### 24/11/2022
### First Release
- This application is a calculator which can currently solve reverse polish notion expressions.
- The calculator can perfrom expressions with +, -, * and / operations.
- It is compatible with decimal and intgers but output will always be in decimal.
