import csv

BU={""}
RANK_POOL={""}
BU_TEAM_LEVEL={""}

with open('C:/Users/ad17891/Downloads/inthemoment.txt', 'r') as text_file:
    reader=csv.DictReader(text_file, delimiter='\t')
    for line in reader:
        #print(line['RANK_POOL']+" "+line['FULLNAME']+" "+line['BUSINESS_UNIT_ID']+" "+line['BU_TEAM_LEVEL'])
        BU.add(line['BUSINESS_UNIT_ID'])
        RANK_POOL.add(line['RANK_POOL'])
        BU_TEAM_LEVEL.add(line['BU_TEAM_LEVEL'])
#print("ANSWER: ")
#print(BU)
#print(RANK_POOL)
#print(BU_TEAM_LEVEL)