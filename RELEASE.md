# **Release Notes**
## **Release-3.3**
### 📅06/12/2022
### 🪲Bug Fix
- Fix bug where if in ASCII view and not set a explict type in beggining it will throw an error.
- Now by default ASCII view is set type postfix by default.

## **Release-3.2**
### 📅06/12/2022
### 🪲Bug Fix
- Fix bug where prescion was lost with numbers too large or small
Example🔎:
<pre>
Expression: 100000000 100000 *
Output Expression Before: 9999999827968
Output Expression After: 10000000000000
</pre>

<br />

## **Release-3.1**
### 📅05/12/2022
### 🌟New
- I update text to use the term 'postfix' instead of 'polish'.
- Simplified error messages, keeping them short and not too long.
### 🪲Bug Fix
- Fix bug where in ASCII Mode when switching between postfix or infix, output was repeating twice.

<br />

## **Release-3.0**
### 📅05/12/2022
### 🌟New
- ASCII mode has been created for the application.
- To open application in ASCII mode open up terminal and type 'java -jar' followed by the name of the jar file for the application:
<br>
Example🔎:
<pre>
java -jar application_name
</pre>
- ASCII mode has the following commands:
    1. P - To switch to postfix mode
    2. I - To switch to infix mode
    3. ? - To enter an expression
    4. G - To get previous valid expression
    5. C - To evalaute a expression
    6. H - To open up help menu
    7. Q - To quit the application

<br />

## **Release-2.4**
### 📅04/12/2022
### 🪲Bug Fix
- Fixed bug where some error messages were not being displayed fully, to fix this i shifted all componets upwards.

<br />

## **Release-2.3**
### 📅04/12/2022
### 🌟New
- Add instructions on how to use the calculator on top of the application.
- Instruction just says to use spaces between operators and symbols.

<br />

## **Release-2.2**
### 📅03/12/2022
### 🪲Bug Fix
- Remove bug where incorrect error message was being displayed.
An example in inifx mode:
An example🔎:
<pre>
    Before: 10 + + 10 Outputs: Inavlid postfix expression
    After: 10 + + 10 Outputs: Inavlid infix expression
</pre>

<br />

## **Release-2.1**
### 📅03/12/2022
### 🪲Bug Fix
- Remove bug where postfix expressions were being evaluated in infix mode.

<br />

## **Release-2.0**
### 📅03/12/2022
### 🌟New
- Calculator can now perform infix expressions.
An example🔎:
<pre>
    Before: 68 * 2 / 4 
    Outputs: 34
</pre>
- Radio buttons on calculator to switch between postfox and infix.
- Infix expressions will give operations prority symbols to follow BIDMAS. List of prority from highest to lowest:
    1. Brackets
    2. Division
    3. Multiply
    4. Addition
    5. Subtraction
<br />

## **Release-1.5**
### 📅30/11/2022
### 🌟New
- Removing scientifc notation from calculator output.
<br />
An example🔎:
<pre>
    Before: 10000 10000 * 
    Outputs: 1.0E8

    After: 10000 10000 * 
    Outputs: 100000000
</pre>

<br />

## **Release-1.4**
### 📅26/11/2022
### 🪲Bug Fix
- Fixed bug where after entering a valid expression after an invalid one, the ouptut will be incorrect or throw an error. <br />
An example🔎:
<pre>
    Expression 1: 10 10 gives an error
    Expression 2: 5 5 + Outputs an error or outputs 15
</pre>

<br />

## **Release-1.3**
### 📅25/11/2022
### 🪲Bug Fix
- Fixed bug for a special case where when a user types **10 10** as an expression it would not output an invalid expression. This is because there was no operators in this expression, to perform an evaluation.

<br />

## **Release-1.2**
### 📅25/11/2022
### 🪲Bug Fix
- Fixed bug where error message was not being output to screen when an invalid expression had been enterd.
- Fixed bug where error message was not being outputed when unrecognisable operator was detected.

<br />

## **Release-1.1** 
### 📅24/11/2022
### 🌟New
- Font size has increased to make numbers easy to read.
- Application is not resizable anymore to prevent components from overlapping one another.
- Postfix and Infix radio buttons have been deleted as the calculator can **only** perform postfix calculations. 

<br />

## **Release-1.0** 
### 📅24/11/2022
### 🎉First Release
- This application is a calculator which can currently solve reverse polish notion expressions.
- The calculator can perfrom expressions with +, -, * and / operations.
- It is compatible with decimal and intgers but output will always be in decimal.
