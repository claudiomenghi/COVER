COVER (Change-based gOal VErifier and Reasoner) is a prototype tool realized as a Java 8 stand-alone application.  
 
## Overview
The requirement engineer produces a goal model which describes the requirements of the system.
Some of the goals are also associated with LTL properties that formally describe the allowed behaviors  of the system.
The goal model enriched with the LTL properties is kept alive during the software development. 

At each development step, i.e., whenever the designer produces a new increment or changes something in the model, the new (incomplete) design of the system is verified against the LTL properties.
Since the model is incomplete the verification procedure may propose three different values, **T** if the property is satisfied by the current design independently from the undefined part of the system, **F** if it is not, or **?** whether its satisfaction depends on the parts which still have to be refined.

The verification results are used to trigger the goal model analysis and to examine the consequences of the requirement satisfaction over the goals of the goal model.

This technique offers several benefits. 
* it makes designers conscious about the consequences of their design choices. 
* whenever a new increment is proposed, designers may analyze the consequences of their changes over the all goal model.     
* yhe analysis may also show inconsistencies of requirements and allow an early contract negotiation between the developer and the requirement engineer. 

This would allow an early detection of design errors and of inconsistencies in the requirements. 

## Components
COVER uses 
* the Goal Reasoning Tool (Gr-tool) as a design framework of  goal models  and for the label propagation <http://troposproject.org/tools/grtool/>;
* the CHecker for Incomplate Automata (\texttt{CHIA}) as a model checking framework <https://github.com/claudiomenghi/CHIA>.

When the requirement engineer designs the goal model using the Gr-tool, she/he also adds the LTL property specification associated with some of its goals.
To LTL property is added after the : symbol inside the goal of the goal model

## Workflow
COVER works through the following steps
* parses the .goal file created by the Gr-tool and extracts the LTL formulae associated with these goals.
* loads the  (I)BA containing the (incomplete)  model of the system which is provided through an appropriate XML file.
* verifies the LTL formulae over the IBA. 
* uses verification results as initial values for the label propagation algorithm.
* propagates the results
* writes the obtained results back into the .goal file.
* the results can be analyzed by the requirement engineer using the Gr-tool.

##Installation
To install COVER
* download the Gr-Tool from <http://troposproject.org/tools/grtool/>
* download the COVER framework from <https://github.com/claudiomenghi/COVER/releases>
* download the ltl2ba C library from <https://github.com/claudiomenghi/COVER/releases>
* compile ltl2ba. Rename the compiled file and make it available to COVER by placing it in the parent folder in which COVER is placed

##Use
1. open the Gr-Tool 
2. design your goal model. An LTL property can be associated to a goal g, by adding a semicolumn ":" and the LTL property to the name of the goal.
3. save your goal model, e.g., in the file model.goal
4. design your IBA with interface 
5. save your design into an appropriate XML file, e.g., in the file design.xml
6. run COVER by typing the command <code>java -jar COVER.jar model.goal design.xml newmodel.goal</code> where
    1. <code>model.goal</code> contains the original goal model;
    2. <code>design.xml</code> contains the current design (the IBA);
    3. <code>newmodel.goal</code> contains the goal model updated with the values obtained by COVER
7. open the generated file (i.e., <code>newmodel.goal</code>) with the Gr-Tool
