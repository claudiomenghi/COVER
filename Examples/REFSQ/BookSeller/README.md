# Book Seller Example

The book seller example has been used in the paper *Integrating Goal Model Analysis with Iterative Design* submitted to REFSQ 2017.

In the following we describe the content of each file

- GoalModel.goal contains the goal model to be considered
- Design.lts contains the design D1, D2 and D3. To use these design in COVER use the processes D1_PROC, D2_PROC and D3_PROC
- resultsD1.goal contains the results obtained considering the process D1_PROC, i.e., design D1
- resultsD2.goal contains the results obtained considering the process D2_PROC, i.e., design D2
- resultsD3.goal contains the results obtained considering the process D3_PROC, i.e., design D3


To replicate the results run the commands

- java -jar COVER1.0.0.jar GoalModel.goal Design.lts D1_PROC resultsD1.goal
- java -jar COVER1.0.0.jar GoalModel.goal Design.lts D2_PROC resultsD2.goal
- java -jar COVER1.0.0.jar GoalModel.goal Design.lts D3_PROC resultsD3.goal
