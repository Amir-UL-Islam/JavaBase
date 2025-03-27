# Here is the working code of the naive approach.
def bruteSearch(W, T):
    # edge case check
    if W == "":
        return -1

    # getting the length of the strings
    wordLen = len(W)
    textLen = len(T)

    # i is the index of text T from where we will start comparing the
    # the word W
    i = 0

    # length of the subtext has to be equal to the length of the word,
    # so no need to check beyond (textLen - wordLen + 1) // approach for optimization
    while i < (textLen - wordLen + 1):
        # we set match to false if we find a mismatch
        match = True

        for j in range(wordLen):
            if W[j] != T[i + j]:
                # A mismatch
                match = False
                break

        if match:
            # We found a match at index i
            print ("There is a match at " + str(i))

        # incrementing i is like shifting the word by 1
        i += 1

    return -1

print(bruteSearch("dog", "canyoufindthedog"))
