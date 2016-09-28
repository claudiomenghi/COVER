COVER (Change-based gOal VErifier and Reasoner) is a prototype tool realized as a Java 8 stand-alone application.  

## Overview
The requirement engineer produces a goal model which describes the requirements of the system.
Some of the goals are also associated with FLTL properties that formally describe the allowed behaviors  of the system.

At each development step, i.e., whenever the designer produces a new increment or changes something in the model, the new (incomplete) design of the system is verified against the FLTL properties.
Since the model is incomplete the verification procedure may propose three different values, **T** if the property is satisfied by the current design independently from the undefined part of the system, **F** if it is not, or **?** whether its satisfaction depends on the parts which still have to be refined.

The verification results are used to trigger the goal model analysis and to examine the consequences of the requirement satisfaction over the goals of the goal model.

This technique offers several benefits. 
* it makes designers conscious about the consequences of their design choices. 
* whenever a new increment is proposed, designers may analyze the consequences of their changes over the all goal model.     
* the analysis may also show inconsistencies of requirements and allow an early contract negotiation between the developer and the requirement engineer. 

This would allow an early detection of design errors and of inconsistencies in the requirements. 

## Components
COVER uses 
* the Goal Reasoning Tool (Gr-tool) as a design framework of  goal models  and for the label propagation <http://troposproject.org/tools/grtool/>;
* the Modal Transition System Analyzer (MTSA) as a model checking framework <http://mtsa.dc.uba.ar/>.

After the requirement engineer designs the goal model using the Gr-tool, she/he also adds the FLTL property specification associated with some of its goals.
The developer design the system using MTS.
The FLTL properties are verified over the MTS

## Workflow
COVER works through the following steps
* parses the .goal file created by the Gr-tool and extracts the identifiers of the goals that are specified through FLTL formulae associated.
* loads the FLTL formula from the .lts file which also contains the model produced by the developer. 
* loads the MTS that describes the behavior of the system from the .lts file
* verifies the FLTL formulae over the MTS. 
* uses verification results as initial values for the label propagation algorithm.
* propagates the results
* writes the obtained results back into the .goal file.
* the results can be analyzed by the requirement engineer using the Gr-tool.

##Installation
To install COVER
* download the Gr-Tool from <http://troposproject.org/tools/grtool/>
* download the COVER framework from <https://github.com/claudiomenghi/COVER/releases>
* download the MTSA from <http://mtsa.dc.uba.ar/>

##Use
1. open the Gr-Tool 
2. design your goal model. The identifier of the goal is separated from its description by a semicolumn ":", i.e., G2: Quote Given 
3. save your goal model, e.g., in the file model.goal
4. create a .lts file using MTSA
5. specify the FLTL description of goals through assertions, i.e., assert G2=([](F_REQUEST_QUOTE-><>F_SYSTEM_PROVIDES_QUOTES)) 
Note that the identifier of the assertion must mach the identifier used for the goal.
4. design your MTS using MTSA
5. save your design into an appropriate .lts file
6. run COVER by typing the command <code>java -jar COVER.jar goalModelInitial.goal design.lts PROCESS finalGoalModel.goal</code> where
    1. <code>goalModelInitial.goal</code> contains the original goal model;
    2. <code>design.lts</code> contains the current design (the MTS);
    3. <code>PROCESS</code> contains the identifier of the process to be considered in the file design.lts
    3. <code>finalGoalModel.goal</code> contains the goal model updated with the values obtained by COVER
7. open the generated file (i.e., <code>finalGoalModel.goal</code>) with the Gr-Tool
