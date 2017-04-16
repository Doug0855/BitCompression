# BitCompression
Implementing dictionary based compression methods

# Compression Methods Used
Dictionary Based Compression: creates a list of the 16 most repeated instructions, and maps any direct matches to their index in the dictionary

Run Length Encoding: Replaces repeated compressed lines with a flag and the number of times the original line is repeated. 

4 bit Bitmask Compression: If any line is a 4 bit XOR away from a dictionary entry, replace that line with a flag, the 4 bit bitmask, and the start location of that bitmask

1-Bit mistmatch: If any line is 1 bit off of a dictionary entry, replace that line with a flag and the location of the mistmatch

2-bit consecutive mismatch: Same as 1-bit but for a 2 bit long mismatch

4-bit consecutive mismatch: Same as 1-bit for a 4 bit mismatch

2 1-bit mismatches: Same as 1-bit mistmatch, but for 2 different non consecutive locations


