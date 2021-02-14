import os
import secrets
from flask import url_for, current_app, flash
from pathlib import Path
from tool import app
import csv
from tool.models import leaderboard, inthemoment, configuration
from tool import db
import shutil

leaderboard_final_data = []
inthemoment_final_data = []

def check_file_content(file, name):
    print(name)
    if name=="Leaderboard":
        with open(file, 'r') as txt_file:
            first_line=txt_file.readline()
            
            error=[]
            if len(first_line)==0:
                error.append("Input file is empty")
                return error

            list_of_columns=first_line.split("\t")
            unique_columns=set(list_of_columns)

            if "RANK_POOL" in unique_columns or "RANK_POOL\n" in unique_columns:
                pass
            else:
                error.append("RANK_POOL")

            if "BUSINESS_UNIT_ID" in unique_columns or "BUSINESS_UNIT_ID\n" in unique_columns:
                pass
            else:
                error.append("BUSINESS_UNIT_ID")

            if "BU_TEAM_LEVEL" in unique_columns or "BU_TEAM_LEVEL\n" in unique_columns:
                pass
            else:
                error.append("BU_TEAM_LEVEL")
            
            if "FINAL_RANK" in unique_columns or "FINAL_RANK\n" in unique_columns:
                pass
            else:
                error.append("FINAL_RANK")
            
            if "FULLNAME" in unique_columns or "FULLNAME\n" in unique_columns:
                pass
            else:
                error.append("FULLNAME")
            
            if len(error)==0:                
                return "success"
            return error
    elif name.lower()=="inthemoment":
        with open(file, 'r') as txt_file:
            first_line=txt_file.readline()
            
            error=[]
            if len(first_line)==0:
                error.append("Input file is empty")
                return error

            list_of_columns=first_line.split("\t")
            unique_columns=set(list_of_columns)

            if "RANK_POOL" in unique_columns or "RANK_POOL\n" in unique_columns:
                pass
            else:
                error.append("RANK_POOL")

            if "BUSINESS_UNIT_ID" in unique_columns or "BUSINESS_UNIT_ID\n" in unique_columns:
                pass
            else:
                error.append("BUSINESS_UNIT_ID")

            if "BU_TEAM_LEVEL" in unique_columns or "BU_TEAM_LEVEL\n" in unique_columns:
                pass
            else:
                error.append("BU_TEAM_LEVEL")
            
            if "DIFFERENCE_CC_RANK" in unique_columns or "DIFFERENCE_CC_RANK\n" in unique_columns:
                pass
            else:
                error.append("DIFFERENCE_CC_RANK")
            
            if "FULLNAME" in unique_columns or "FULLNAME\n" in unique_columns:
                pass
            else:
                error.append("FULLNAME")
            
            if len(error)==0:
                return "success"
            return error
    else:
        with open(file, 'r') as txt_file:
            first_line=txt_file.readline()
            
            error=[]
            if len(first_line)==0:
                error.append("Input file is empty")
                return error

            list_of_columns=first_line.split("\t")
            unique_columns=set(list_of_columns)
            const=" column missing"

            if "RANK_POOL" in unique_columns or "RANK_POOL\n" in unique_columns:
                pass
            else:
                error.append("RANK_POOL"+const)

            if "RANK_POOL_PSEUDONAME" in unique_columns or "RANK_POOL_PSEUDONAME\n" in unique_columns:
                pass
            else:
                error.append("RANK_POOL_PSEUDONAME"+const)

            if "DATA_TYPE" in unique_columns or "DATA_TYPE\n" in unique_columns:
                pass
            else:
                error.append("DATA_TYPE"+const)
            
            if "RANK_POOL_VISIBILITY_FLAG" in unique_columns or "RANK_POOL_VISIBILITY_FLAG\n" in unique_columns:
                pass
            else:
                error.append("RANK_POOL_VISIBILITY_FLAG"+const)
            
            if "BU_TEAM_LEVEL" in unique_columns or "BU_TEAM_LEVEL\n" in unique_columns:
                pass
            else:
                error.append("BU_TEAM_LEVEL"+const)
            
            if len(error)==0:
                error.append("success")
                return error
            return error

def check_file(filename):
    name=filename.split(".")
    filename=os.path.join(app.config['UPLOAD_FOLDER'], filename)
    my_file = Path(filename)
    print("Function name: check_file()")
    if my_file.exists():
        return check_file_content(my_file, name[0])
    return "no"

def get_filepath(filename):
    filename=os.path.join(app.config['UPLOAD_FOLDER'], filename)
    my_file = Path(filename)
    print("Function name: get_filepath()")
    if my_file.exists():
        return my_file
    return ""

def allowed_file(filename):
    print("Function name: allowed_file()")
    return '.' in filename and \
           filename.rsplit('.', 1)[1].lower() =="txt"

def import_file_to_database():
    print("Function name: import_file_to_database()")
    leaderboard_filename='Leaderboard.txt'
    inthemoment_filename='InTheMoment.txt'
    print("InTheMoment File Status: "+check_file(leaderboard_filename))
    if check_file(leaderboard_filename)=="success":
        leaderboard_filename=os.path.join(app.config['UPLOAD_FOLDER'], leaderboard_filename)

        with open(leaderboard_filename, 'r') as text_file:
            reader=csv.DictReader(text_file, delimiter='\t')

            for line in reader:
                BU = str(line['BUSINESS_UNIT_ID'])
                RANK_POOL = str(line['RANK_POOL'])
                BU_TEAM_LEVEL = str(line['BU_TEAM_LEVEL'])
                FINAL_RANK = int(line['FINAL_RANK'])
                FULLNAME = str(line['FULLNAME'])
                
                if(FINAL_RANK<=10):
                    ld1=leaderboard(RANK_POOL=RANK_POOL, BU=BU, BU_TEAM_LEVEL=BU_TEAM_LEVEL, FINAL_RANK=FINAL_RANK, FULLNAME=FULLNAME)
                    db.session.add(ld1)
            db.session.commit()
    print("InTheMoment File Status: "+str(check_file(inthemoment_filename)))
    if check_file(inthemoment_filename)=="success":
        inthemoment_filename=os.path.join(app.config['UPLOAD_FOLDER'], inthemoment_filename)

        with open(inthemoment_filename, 'r') as text_file:
            reader=csv.DictReader(text_file, delimiter='\t')
            
            for line in reader:
                BU = str(line['BUSINESS_UNIT_ID'])
                RANK_POOL = str(line['RANK_POOL'])
                BU_TEAM_LEVEL = str(line['BU_TEAM_LEVEL'])
                DIFFERENCE_CC_RANK = int(line['DIFFERENCE_CC_RANK']) if line['DIFFERENCE_CC_RANK']!='' else 0
                FULLNAME = str(line['FULLNAME'])
                
                if(DIFFERENCE_CC_RANK>0):
                    ld1=inthemoment(RANK_POOL=RANK_POOL, BU=BU, BU_TEAM_LEVEL=BU_TEAM_LEVEL, DIFFERENCE_CC_RANK=DIFFERENCE_CC_RANK, FULLNAME=FULLNAME)
                    db.session.add(ld1)
            db.session.commit()
    

def populate_dropdown(form):
    print("Function name: populate_dropdown()")
    code_distinct_BU = "SELECT DISTINCT BU FROM leaderboard"
    distinct_BU = db.session.execute(code_distinct_BU)
    xyz=['BU']
    form.select_BU.choices = xyz + [(leaderboard.BU) for leaderboard in distinct_BU]
    form.select_BU_TEAM_LEVEL.choices = [('BU_TEAM_LEVEL')]

    return form

def populate_BTL(form, selected_bu):
    print("Function name: populate_BTL()")
    code_distinct_BTL = "SELECT DISTINCT BU_TEAM_LEVEL FROM leaderboard WHERE BU="+"'"+selected_bu+"'"
    distinct_BTL = db.session.execute(code_distinct_BTL)
    xyz = ['BU_TEAM_LEVEL']
    form.select_BU_TEAM_LEVEL.choices = xyz + [(leaderboard.BU_TEAM_LEVEL) for leaderboard in distinct_BTL]
    code_distinct_BU = "SELECT DISTINCT BU FROM leaderboard"
    distinct_BU = db.session.execute(code_distinct_BU)
    form.select_BU.choices = [(leaderboard.BU) for leaderboard in distinct_BU]
    return form

def get_leaderboard_rankpool(selected_bu, selected_btl):
    print("Function name: get_leaderboard_rankpool()")
    code_distinct_RANK_POOL = "SELECT * FROM configuration where BU_TEAM_LEVEL="+"'"+selected_btl+"'"+" AND DATA_TYPE="+"'"+"LEADERBOARD"+"'"
    distinct_RANK_POOL = db.session.execute(code_distinct_RANK_POOL)
    rank_pool=[]
    for data in distinct_RANK_POOL:
        rank_pool.append(data)
    return rank_pool

def get_inthemoment_rankpool(selected_bu, selected_btl):
    print("Function name: get_inthemoment_rankpool()")
    code_distinct_RANK_POOL = "SELECT * FROM configuration where BU_TEAM_LEVEL="+"'"+selected_btl+"'"+" AND DATA_TYPE="+"'"+"INTHEMOMENT"+"'"
    distinct_RANK_POOL = db.session.execute(code_distinct_RANK_POOL)
    rank_pool=[]
    for data in distinct_RANK_POOL:
        rank_pool.append(data)
    return rank_pool

def delete_existing_database():
    print("Function name: delete_existing_database()")
    leaderboard.query.delete()
    inthemoment.query.delete()

def create_configuration():
    print("Function name: create_configuration()")
    # Query Leaderboard
    query = "SELECT DISTINCT RANK_POOL, BU_TEAM_LEVEL  from leaderboard"
    data = db.session.execute(query)
    for row in data:
        RANK_POOL = row['RANK_POOL']
        DATA_TYPE = "LEADERBOARD"
        BU_TEAM_LEVEL = row['BU_TEAM_LEVEL']

        updater = configuration(RANK_POOL=RANK_POOL, DATA_TYPE=DATA_TYPE, BU_TEAM_LEVEL=BU_TEAM_LEVEL)
        db.session.add(updater)
    print("Leaderboard Configration Updated")
    # Query InTheMoment
    query = "SELECT DISTINCT RANK_POOL, BU_TEAM_LEVEL from inthemoment"
    data = db.session.execute(query)
    i=1
    for row in data:
        i=i+1
        RANK_POOL = row['RANK_POOL']
        DATA_TYPE = "INTHEMOMENT"
        BU_TEAM_LEVEL = row['BU_TEAM_LEVEL']

        updater = configuration(RANK_POOL=RANK_POOL, DATA_TYPE=DATA_TYPE, BU_TEAM_LEVEL=BU_TEAM_LEVEL)
        db.session.add(updater)
    print("IntheMoment COnfiguration updated "+str(i))
    db.session.commit()

def delete_existing_configuration():
    print("Function name: delete_existing_configuration()")
    configuration.query.delete()
    db.session.commit()
    print("configuraation deleted")

def update_configuration(config_id, rankpool_visibility_flag):
    print("Function name: update_configuration()")
    update_query = configuration.query.filter_by(Id=config_id).first()
    update_query.RANK_POOL_VISIBILITY_FLAG = int(rankpool_visibility_flag)
    db.session.commit()

def update_configuration_rankpool_pseudoname(config_id, pseudoname):
    print("Function name: update_configuration_rankpool_pseudoname()")
    update_query = configuration.query.filter_by(Id=config_id).first()
    update_query.RANK_POOL_PSEUDONAME = str(pseudoname)
    db.session.commit()

def upload_config(upload_config_file, filename):
    print("Function name: upload_config()")
    temp_upload_config_file_location = os.path.join(app.config['TEMP_UPLOAD_FOLDER'], "temp_configuration.txt")
    upload_config_file.save( temp_upload_config_file_location )
    err=[]
    #flash( allowed_file(filename))
    if allowed_file(filename) == True:
        return check_file_content(Path(temp_upload_config_file_location), "configuration")
    err.append("Incorrect File Extention")
    return err

def create_configuration_file():
    print("Function name: create_configuration_file()")
    pull_config_data = "SELECT * from configuration"
    data = db.session.execute(pull_config_data)
    filename=os.path.join(app.config['UPLOAD_FOLDER'], "configuration.txt")
    #upload_config_file.save(filename)
    if os.path.exists(filename):
        os.remove(filename)
    with open(filename, 'w') as text_file:
        line="RANK_POOL_PSEUDONAME"+"\t"+"RANK_POOL"+"\t"+"BU_TEAM_LEVEL"+"\t"+"DATA_TYPE"+"\t"+"RANK_POOL_VISIBILITY_FLAG"+"\n"
        for row in data:
            RANK_POOL_PSEUDONAME ="" if row['RANK_POOL_PSEUDONAME']==None else row['RANK_POOL_PSEUDONAME']
            RANK_POOL = "" if row['RANK_POOL']==None else row['RANK_POOL']
            BU_TEAM_LEVEL = "" if row['BU_TEAM_LEVEL']==None else row['BU_TEAM_LEVEL']
            DATA_TYPE = "" if row['DATA_TYPE']==None else row['DATA_TYPE']
            RANK_POOL_VISIBILITY_FLAG = str(row['RANK_POOL_VISIBILITY_FLAG'])
            line = line + RANK_POOL_PSEUDONAME + "\t" + RANK_POOL +"\t" + BU_TEAM_LEVEL + "\t" + DATA_TYPE + "\t" + RANK_POOL_VISIBILITY_FLAG + "\n"
        text_file.write(line)
    print("Configuration .txt file created")


def import_configuration_to_database():
    print("Function name: import_configuration_to_database()")
    filename="configuration.txt"
    filename=os.path.join(app.config['UPLOAD_FOLDER'], filename)
    with open(filename, 'r') as text_file:
        reader=csv.DictReader(text_file, delimiter='\t')

        for line in reader:
            RANK_POOL_PSEUDONAME = str(line['RANK_POOL_PSEUDONAME'])
            RANK_POOL = str(line['RANK_POOL'])
            BU_TEAM_LEVEL = str(line['BU_TEAM_LEVEL'])
            DATA_TYPE = str(line['DATA_TYPE'])
            RANK_POOL_VISIBILITY_FLAG = 0 if line['RANK_POOL_VISIBILITY_FLAG']=='' else int(line['RANK_POOL_VISIBILITY_FLAG'])
            
            ld1=configuration(RANK_POOL_PSEUDONAME=RANK_POOL_PSEUDONAME, RANK_POOL=RANK_POOL, BU_TEAM_LEVEL=BU_TEAM_LEVEL, DATA_TYPE=DATA_TYPE, RANK_POOL_VISIBILITY_FLAG=RANK_POOL_VISIBILITY_FLAG)
            db.session.add(ld1)
        db.session.commit()
    print("Import completed")

def temp_to_confirm_config():
    print("Function name: temp_to_confirm_config()")
    temp = "temp_configuration.txt"
    perm = "configuration.txt"
    temp = os.path.join(app.config['TEMP_UPLOAD_FOLDER'], temp)
    perm = os.path.join(app.config['UPLOAD_FOLDER'], perm)
    shutil.move(temp, perm)

def get_ChairmanCircle_leaderboard(current_BU_TEAM_LEVEL):
    print("Function name: get_ChairmanCircle_leaderboard()")
    print("current_BU_TEAM_LEVEL: "+current_BU_TEAM_LEVEL)
    ## SQL QUERY TO CAPTURE "RANK_POOL" AND "RANK_POOL_PSEUDONAMES" FROM "CONFIGURATIONS" FILE WRT "CURRENT__BUTEAMLEVEL"
    query_rankpool = "SELECT DISTINCT RANK_POOL_PSEUDONAME, RANK_POOL from configuration WHERE BU_TEAM_LEVEL="+"'"+current_BU_TEAM_LEVEL+"'"+" AND DATA_TYPE LIKE '%LEADERBOARD%' AND RANK_POOL_VISIBILITY_FLAG='1'"
    data = db.session.execute(query_rankpool)
    final_data = []

    ## TRAVERSE EACH RANKPOOL IN LEADERBOARD FILE WRT THE SELECTED BU_TEAM_LEVEL
    for row in data:
        temp_rankpool = row['RANK_POOL']
        temp_pseudoname = row['RANK_POOL_PSEUDONAME']
        if temp_pseudoname == None:
            temp_pseudoname = ""
        elif temp_pseudoname.strip() == "":
            temp_pseudoname = ""
        elif temp_pseudoname == "None":
            temp_pseudoname = ""
        ## QUERY FOR THE WINNERS IN LEADERBOARD WRT THE SELECTED RANKPOOL IN "temp_rankpool"
        query_leaderboard = "SELECT FULLNAME, FINAL_RANK FROM leaderboard WHERE RANK_POOL="+"'"+temp_rankpool+"'"+" AND FINAL_RANK<=10 ORDER BY FINAL_RANK"
        data_leaderboard_reps = db.session.execute(query_leaderboard)

        temp_reps = []
        ## TRAVERSE LEADERBOARD REPS
        for reps in data_leaderboard_reps:
            temp_fullname = reps['FULLNAME']
            temp_rank = reps['FINAL_RANK']
            temp_list = []
            temp_list.append(temp_fullname)
            temp_list.append(temp_rank)
            temp_reps.append(temp_list)
        
        ## JOIN RANKPOOL AND ITS CORROSPONDING REPS
        component = []
        component.append(temp_pseudoname)
        component.append(temp_reps)

        final_data.append(component)
    global leaderboard_final_data
    leaderboard_final_data = final_data.copy()
    print("Value of leaderboard_final_data: "+str(leaderboard_final_data))
    return final_data

def get_ChairmanCircle_inthemoment(current_BU_TEAM_LEVEL):
    print("Function name: get_ChairmanCircle_inthemoment()")
    print("current_BU_TEAM_LEVEL: "+current_BU_TEAM_LEVEL)
    ## SQL QUERY TO CAPTURE "RANK_POOL" AND "RANK_POOL_PSEUDONAMES" FROM "CONFIGURATIONS" FILE WRT "CURRENT__BUTEAMLEVEL"
    query_rankpool = "SELECT DISTINCT RANK_POOL_PSEUDONAME, RANK_POOL from configuration WHERE BU_TEAM_LEVEL="+"'"+current_BU_TEAM_LEVEL+"'"+" AND DATA_TYPE LIKE '%INTHEMOMENT%' AND RANK_POOL_VISIBILITY_FLAG='1'"
    data = db.session.execute(query_rankpool)
    final_data = []

    ## TRAVERSE EACH RANKPOOL IN INTHEMOMENT FILE WRT THE SELECTED BU_TEAM_LEVEL
    for row in data:
        temp_rankpool = row['RANK_POOL']
        temp_pseudoname = row['RANK_POOL_PSEUDONAME']
        if temp_pseudoname == None:
            temp_pseudoname = ""
        elif temp_pseudoname.strip() == "":
            temp_pseudoname = ""
        elif temp_pseudoname == "None":
            temp_pseudoname = ""
        ## QUERY FOR THE REPS IN INTHEMOMENT WRT THE SELECTED RANKPOOL IN "temp_rankpool"
        query_inthemoment = "SELECT FULLNAME, DIFFERENCE_CC_RANK FROM inthemoment WHERE RANK_POOL="+"'"+temp_rankpool+"'"+" AND DIFFERENCE_CC_RANK>0 ORDER BY DIFFERENCE_CC_RANK DESC"
        data_inthemoment_reps = db.session.execute(query_inthemoment)

        temp_reps = []
        i=0
        ## TRAVERSE LEADERBOARD REPS
        for reps in data_inthemoment_reps:
            if(i==10):
                break;
            temp_fullname = reps['FULLNAME']
            temp_diff_rank = reps['DIFFERENCE_CC_RANK']
            temp_list = []
            temp_list.append(temp_fullname)
            temp_list.append(temp_diff_rank)
            temp_reps.append(temp_list)
            i+1
        
        ## JOIN RANKPOOL AND ITS CORROSPONDING REPS
        component = []
        component.append(temp_pseudoname)
        component.append(temp_reps)

        final_data.append(component)
    global inthemoment_final_data
    inthemoment_final_data = final_data.copy()
    print("Value of leaderboard_final_data: "+str(inthemoment_final_data))
    return final_data

def retrieve_leaderboard_data():
    return leaderboard_final_data

def retrieve_inthemoment_data():
    return inthemoment_final_data
