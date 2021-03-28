package USACOBRONZE.Jan2017;

public class usacoThingy {
    /*
    Farmer John owns 7 dairy cows: Bessie, Elsie, Daisy, Gertie, Annabelle, Maggie, and Henrietta. He milks them every day and keeps detailed records on the amount of milk provided by each cow during each milking session. Not surprisingly, Farmer John highly prizes cows that provide large amounts of milk.
Cows, being lazy creatures, don't necessarily want to be responsible for producing too much milk. If it were up to them, they would each be perfectly content to be the lowest-producing cow in the entire herd. However, they keep hearing Farmer John mentioning the phrase "farm to table" with his human friends, and while they don't quite understand what this means, they have a suspicion that it actually may not be the best idea to be the cow producing the least amount of milk. Instead, they figure it's safer to be in the position of producing the second-smallest amount of milk in the herd. Please help the cows figure out which of them currently occupies this desirable position.
INPUT FORMAT (file notlast.in):
The input file for this task starts with a line containing the integer N (1≤N≤100), giving the number of entries in Farmer John's milking log.
Each of the N following lines contains the name of a cow (one of the seven above) followed by a positive integer (at most 100), indicating the amount of milk produced by the cow during one of its milking sessions.
Any cow that does not appear in the log at all is assumed to have produced no milk.
OUTPUT FORMAT (file notlast.out):
On a single line of output, please print the name of the cow that produces the second-smallest amount of milk. More precisely, if M is the minimum total amount of milk produced by any cow, please output the name of the cow whose total production is minimal among all cows that produce more than M units of milk. If several cows tie for this designation, or if no cow has this designation (i.e., if all cows have production equal to M), please output the USACO.Jan2020.word "Tie". Don't forget to add a newline character at the end of your line of output. Note that M=0 if one of the seven cows is completely absent from the milking log, since this cow would have produced no milk.
SAMPLE INPUT:
10
Bessie 1
Maggie 13
Elsie 3
Elsie 4
Henrietta 4
Gertie 12
Daisy 7
Annabelle 10
Bessie 6
Henrietta 5
SAMPLE OUTPUT:
Henrietta
In this example, Bessie, Elsie, and Daisy all tie for the minimum by each producing 7 units of milk. The next-largest production, 9 units, is due to Henrietta.
Problem credits: Brian Dean - Jan 2017
1. Main idea of the question (simplify in 1 - 2 sentence)
Find the second least amount of milk produced out of the 7 cows given.
2. Conclude how the Input turn to Output (the process)
Add all of the cows amount of milk then compare each amount and find the second lowest one. If the second lowest one is tied than
output "Tied"
3. Range for Input (N or K or any range mentioned in question)
1 <= N <= 100
3. What are the mandatory requirements to pass
The mandatory requirements to pass is to return a cow name or "Tied"
4. any edge case
if there are ties than return "Tied" if its 1 cow than return the one cow name
5. pseudo code (Reference: https://www.unf.edu/~broggio/cop2221/2221pseu.htm)

intitalize number of logs
intitalize array of all cows
intitalize frequence holder of amount of milk of each cow

loop of how many logs
    loop of cow names
        if the name of the cow matches with the string given from the input add
        the amount to the corresponding index in the freqeunce array
        break

loop of frequence array
    find second lowest value
    find lowest value in arraylisr first
    then remove lowest value from arraylist
    then find new lowest value which is second lowest
    if there are duplicate than one print "tied"
    if there is only one find the corresponding name and print that

close file

1. Main idea of the question (simplify in 1 - 2 sentence)
Using all possible combos find which cow can get the most wins in rock paper hoof.
2. Conclude how the Input turn to Output (the process)
Use brute force to change what each number means 3 times and use the combo with the most victories as the answer.
3. Range for Input (N or K or any range mentioned in question)
1,2,3
4. What are the mandatory requirements to pass
find the biggest nunmber of victories you can get from each combo of hoof scissor paper
5. any edge case
none
6. pseudo code (Reference: https://www.unf.edu/~broggio/cop2221/2221pseu.htm)
initialize amount of rounds
intitalize array of hoof paper scissor
intitialize count
intitialize count2
intitalize 2d array of rounds
intitalize temp
intitalize answer
loop of rounds
    input data into array in 2d array
loop of three
    count reset to zero
    loop of amount of rounds
    if the corresponding string to the number beats the other corresponding number string than add to count
    else than add to count2
    check for each case

change array into different order using a temperorary string and techniques
change 1,2,3 array
temp equals max of count and count2 to find most vicotories
answer equals biggest temp out of all rounds

return answer
out close
     */
}
