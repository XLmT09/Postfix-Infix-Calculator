# **Changelog**
## **Release-3.5 , 09-12-2022**
#### <span style="background-color:#515A5A;padding:3px;border;border-radius: 3px;">**Refactoring**</span> 
- Refactor CalcController to not do any number formatting with the final result, i move the formatting operation into the RevPolishCalc as thats the class which is actually meant to be doing the formatting.
- Moved EntryInterface to entry package.
- Make constructors for views to pass complience testing.
### <span style="background-color:#B03A2E;padding:3px;border;border-radius: 3px;">**Bug Fix**</span>
- Fixed divison by zero error by cathcing that the error, previously it wasnt being cathced.
- Fix problem where inifx mode couldnt detect an invalid symbol.

<br />

## **Release-3.4 , 06-12-2022**
### <span style="background-color:#B03A2E;padding:3px;border;border-radius: 3px;">**Bug Fix**</span>
- There was a bug where when numbers get too large the digits overlap on components of the calculator. To fix this i make component holding the answer into a text feild and not a text box.

<br />

## **Release-3.3 , 06-12-2022**
### <span style="background-color:#B03A2E;padding:3px;border;border-radius: 3px;">**Bug Fix**</span>
- There was a bug where ASCII view would not work unless it was first given a type. To fix this i set the default type to POSTFIX.

<br />

## **Release-3.2 , 06-12-2022**
### <span style="background-color:#B03A2E;padding:3px;border;border-radius: 3px;">**Bug Fix**</span>
- There was bug where presion was being lost on calculations when numbers were too large or small.
- To fix this i change the number datatype from float to BigDecimal.

<br />

## **Release-3.1 , 05-12-2022**
#### <span style="background-color:#515A5A;padding:3px;border;border-radius: 3px;">**Refactoring**</span> 
- Created a factory design pattern for the entry class, to decrease coupling of classes. It prevents the stack classes from constructing the objects, the stack class insstead just provides a method.
- Make code modular by grouping classes into packages.
### <span style="background-color:#B03A2E;padding:3px;border;border-radius: 3px;">**Bug Fix**</span>
- There is a bug fix where when chaning modes in ASCII it outputs "chnaged to ... mode" twice, to fix this i delete the duplicate System.println line.

<br />

## **Release-3.0 , 04-12-2022**
### <span style="background-color:#196F3D;padding:3px;border;border-radius: 3px;">**Feature Added**</span>
- Create a new feature branch called **feature-ASCII_VIEW**, the goal is to implement a terminal based calculator for the user.
### <span style="background-color:#196F3D;padding:3px;border;border-radius: 3px;">**Added**</span>
- Make ASCII View avaialbe to work from the launcher class.
- Make the driver switch between ASCII and GUI depending on where the programme is being launched.
- ASCII View can work with polish and infix mode.
- Add option where user can get previous expression they enterd.
### <span style="background-color:#B03A2E;padding:3px;border;border-radius: 3px;">**Bug Fix**</span>
- Postfix mode was not working in ASCII View this is because when a user has an empty space in front of there expression it keeps throwing an error. To solve this i trim the empty space at the beggining of the expression before evaluating.
#### <span style="background-color:#6C3483;padding:3px;border;border-radius: 3px;">**Merge**</span> 
- Merge **feature-ASCII_VIEW** back to main.

<br />

## **Release-2.4 , 04-12-2022**
### <span style="background-color:#B03A2E;padding:3px;border;border-radius: 3px;">**Bug Fix**</span>
- Error message was not being fully displayed on screen because there is not enough room on the calculator app, so the size of thw whole application is increased to provide space for the message.

<br />

## **Release-2.3 , 04-12-2022**
### <span style="background-color:#196F3D;padding:3px;border;border-radius: 3px;">**Added**</span>
- To imporve user experience i add an instruction on how to create
expressions for the calculator, where there must be a space between
every number and symbol. If i did not include this here the user may
have been confused about why there expression was wrong when they dont
include spaces.

<br />

## **Release-2.2 , 03-12-2022**
### <span style="background-color:#B03A2E;padding:3px;border;border-radius: 3px;">**Bug Fix**</span>
- Fix a bug incorrect postfix error messages were being displayed in infix mode, to fix this i just change the message in the throw statement for the error.

<br />

## **Release-2.1 , 03-12-2022**
### <span style="background-color:#B03A2E;padding:3px;border;border-radius: 3px;">**Bug Fix**</span>
- Fix a bug where postfix expressions were working in infix mode, to fix this the programe checks if two numbers have been entered in a row. If two numbers have been entered with spcae next to each other then the programme will throw an error.

<br />

## **Release-2.0 , 03-12-2022**
### <span style="background-color:#196F3D;padding:3px;border;border-radius: 3px;">**Feature Added**</span>
- Create a new feature branch called **feature-CONNECT_INFIX_TO_GUI**, the goal is to get both postfix and infix calculations working on the GUI.
#### <span style="background-color:#2874A6;padding:3px;border;border-radius: 3px;">**Additions using TDD**</span> 
- Made a new class called CalcModel which switches between the two states infix and postfix.
### <span style="background-color:#196F3D;padding:3px;border;border-radius: 3px;">**Added**</span>
- Updated the controller so that it also becomes an observer for the radio buttons which are being pressed, so that it can respectivily change its state.<br />
i.e if infix button is clicked the observer will see this and change the state of the CalcModel.
- GUIView was also updated to notfiy the observer when a radio button has been pressed.
#### <span style="background-color:#6C3483;padding:3px;border;border-radius: 3px;">**Merge**</span> 
- Merge **feature-STANDARD_CALC** back to main.

<br />

## **Release-2.0 , 01-12-2022 to 02-12-2022**
### <span style="background-color:#196F3D;padding:3px;border;border-radius: 3px;">**Feature Added**</span>
- Create a new feature branch called **feature-STANDARD_CALC** to evaluate infix expressions in the backend, by converting the infix expression to postfix.
#### <span style="background-color:#2874A6;padding:3px;border;border-radius: 3px;">**Additions using TDD**</span> 
- Made a new class called StandardCalc which evaluates infix expressions using the evaluate method, it also checks for operator precedence.
#### <span style="background-color:#6C3483;padding:3px;border;border-radius: 3px;">**Merge**</span> 
- Merge **feature-STANDARD_CALC** back to main.

<br />

## **Release-2.0 , 30-11-2022**
### <span style="background-color:#196F3D;padding:3px;border;border-radius: 3px;">**Feature Added**</span>
- Create a new feature branch called **feature-OP_STACK** to develop an OpStack, which will be a stack to hold operators. This will be needed for the development of the Shunting Algorithm to evaluate infix operations.
#### <span style="background-color:#2874A6;padding:3px;border;border-radius: 3px;">**Additions using TDD**</span> 
- Created a new OpStack class which is a stack that will hold Symbols.
- OpStack class also contains three methods:
    1. **isEmpty** method, to check if it is empty using the size method from stack.
    2. **push** method, to add Entry which represents Symbols into the stack.
    3. **pop** method which pops latest Symbol from stack, and throws exception if stack is empty.
#### <span style="background-color:#6C3483;padding:3px;border;border-radius: 3px;">**Merge**</span> 
- Merge **feature-OP_STACK** back to main.

<br />

## **Release-1.5 , 30-11-2022**
### <span style="background-color:#196F3D;padding:3px;border;border-radius: 3px;">**Added**</span>
- Added release notes for release-1.5.
- Remvoed scientif notation so outputs are just purely numbers, decimal format class was used to do this.

<br />

## **Release-1.4 , 26-11-2022**
### <span style="background-color:#196F3D;padding:3px;border;border-radius: 3px;">**Added**</span>
- Added release notes for release-1.4.
- Clear methods for stack and numstack so that stack can clear all previous numbers and be in a clean state for its next evaluation.
### <span style="background-color:#B03A2E;padding:3px;border;border-radius: 3px;">**Bug Fix**</span>
- Fixed bug where previous numbers from the stack were being used in the newest evaluation call, to fix this the stack will be cleared before evaluating.

<br />

## **Release-1.3 , 25-11-2022**
### <span style="background-color:#196F3D;padding:3px;border;border-radius: 3px;">**Added**</span>
- Added release notes for release-1.3.
### <span style="background-color:#B03A2E;padding:3px;border;border-radius: 3px;">**Bug Fix**</span>
- Fixed bug where when user types "10 10" it should output error but it did not.

<br />

## **Release-1.2 , 25-11-2022**
### <span style="background-color:#196F3D;padding:3px;border;border-radius: 3px;">**Added**</span>
- Configuration and summary of appllication added to readme.
- Added complience check for checkstyle to pass configuration tests before running.
- Added release notes for release-1.2.
### <span style="background-color:#B03A2E;padding:3px;border;border-radius: 3px;">**Bug Fix**</span>
- Fixed bug where errors were not being displayed on the GUI. 

<br />

## **Release-1.1 , 25-11-2022**
### <span style="background-color:#196F3D;padding:3px;border;border-radius: 3px;">**Added**</span>
- Added release notes for version-1.1.
- Increased font size so easier for user to read text.
- Diasabled resizeability to prevent components from overlapping each other.
- Only for this version 1 of the calulator, the radio buttons have been deletd as user can only perform postfix calculations.

<br />

## **Release-1.0 , 24-11-2022**
### **24-11-2022**
### <span style="background-color:#196F3D;padding:3px;border;border-radius: 3px;">**Added**</span>
- Added release notes for version-1.0 which describes a working calculator GUI which uses reverse polish notation.

## **Release-0.0 , 21-11-2022**
### <span style="background-color:#196F3D;padding:3px;border;border-radius: 3px;">**Added**</span> 
 - The GUI and assembly model can now communicate with each other via the Controller class.  When user clicks evaluate button the controller grabs the expression by the user then passes it to the assembly, the assembly then gives an answer for the expression. The Controller grabs the answer and gives it to the GUI for the user to see.
#### <span style="background-color:#6C3483;padding:3px;border;border-radius: 3px;">**Merge**</span> 
- Merge feature-CONNECT_GUI_AND_ASSEMBLY back to main.

<br />

## **Release-0.0 , 19-11-2022 to 20-11-2022**
### **19-11-2022**
#### <span style="background-color:#196F3D;padding:3px;border;border-radius: 3px;">**Added Feature**</span> 
- Created a feature branch called feature-CONNECT_GUI_AND_ASSEMBLY which is aimed to connect the GUI and assembly using an controller class to allow communication between the two.
- Created an class called OpType whcihrepresents what type calculation the evalution method should do.
### **20-11-2022**
#### <span style="background-color:#515A5A;padding:3px;border;border-radius: 3px;">**Refactoring**</span> 
- Driver class shouldnt have any fx code in it, it should just choose which veiw to run, so i make the Driver class call a new class i created called Launcer.java which was written by Dave.
#### <span style="background-color:#196F3D;padding:3px;border;border-radius: 3px;">**Added**</span> 
- Created an ViewInterface class to ensure that 3 methods are provided for every view which are:
    1. getExpression(), which will just get the expression of the String
   implemented by the user.
    2. setAnswer(), which will evaluate the expression.
    3. addCalcObserver(), an observer for the View.

<br />

## **Release-0.0 , 18-11-2022**
#### <span style="background-color:#2874A6;padding:3px;border;border-radius: 3px;">**Additions using TDD**</span> 
- Evaluate method can do addition, subtraction, multiplication and division on mutliple numbers, this was developed bit by bit usind TDD.
- Evaluate method throws errors for invalidExpressions and InvalidOperators.
#### <span style="background-color:#6C3483;padding:3px;border;border-radius: 3px;">**Merge**</span> 
- Merge feature-REV_POLSIH_CALC back to main.

<br />

## **Release-0.0 , 17-11-2022**
#### <span style="background-color:#2874A6;padding:3px;border;border-radius: 3px;">**Additions using TDD**</span> 
- Created constructor with RevPolishCalc.
- Created evaluate method for RevPolishCalc which can currently do additions with multiple numbers.

<br />

## **Release-0.0 , 16-11-2022**
#### <span style="background-color:#6C3483;padding:3px;border;border-radius: 3px;">**Merge**</span> 
- Merge feature-NUM_STACK back to main.
#### <span style="background-color:#196F3D;padding:3px;border;border-radius: 3px;">**Added Feature**</span> 
- Created a feature branch called feature-REV_POLSIH_CALC which focus on builidng the assembly for the calculator of reverse polish.
- Created a RevPolishCalc, TestRevPolishClac and calculator interface classes as a skeleton for this feature.

<br />

## **Release-0.0 , 15-11-2022**
#### <span style="background-color:#196F3D;padding:3px;border;border-radius: 3px;">**Added Feature**</span> 
- created feature called feature-NUM_STACK where this feature is focused in a NumStack class, where stack
will contain only numeric values. This feature is created for the reverse polish calculator.
- Added TestNumStack to test the class.
#### <span style="background-color:#2874A6;padding:3px;border;border-radius: 3px;">**Additions using TDD**</span> 
- Created a isEmpty method for numStack so that it can check if it is empty using the size method from stack.
-  Created a push method for numStack to add Entry which represents numbers into the stack.
- Created the pop method which pops latest float values from, and trhows exception if stack is empty.

<br />

## **Release-0.0 , 07-11-2022 to 08-11-2022**
### **07-11-2022**
#### <span style="background-color:#196F3D;padding:3px;border;border-radius: 3px;">**Added Feature**</span> 
- Created feature branch called feature-GUIView used to build the GUI for the application.
- Setup a javfx.fxml to start implementing an GUI.
- Created an empty GUI window.
### **08-11-2022**
#### <span style="background-color:#196F3D;padding:3px;border;border-radius: 3px;">**Added**</span> 
- Added components to the calculator which include:
    1. Calculate Button.
    2. Radio Buttons for infix and polish.
    3. TextFeild for writing expressions.
    4. Text compnents to label input and ouput.
    5. Another text component which represents the answer.
- Added style directly in the fxml instead of using an external css file.
#### <span style="background-color:#6C3483;padding:3px;border;border-radius: 3px;">**Merge**</span> 
- Merge feature-GUIView back to main.

<br />

## **Release-0.0 , 31-10-2022**
### <span style="background-color:#9C640C;padding:3px;border;border-radius: 3px;">**Revert and Deletions**</span> 
 - Deletd an unwanted directory called test.
 - Reverted an unwanted test commit.

<br />

## **Release-0.0 , 07-10-2022**
### <span style="background-color:#196F3D;padding:3px;border;border-radius: 3px;">**Added**</span> 
 - Added coursework one code into repository as a starting point, which contains:
    - 2 enum classes one which contains symbols an expression can use and another called type which contains the data type that wiill be pushed in a stack.
    - Stack class, used to store symbols and numbers for an expression.
    - Entry class, the datatype that can be pushed into a stack.

