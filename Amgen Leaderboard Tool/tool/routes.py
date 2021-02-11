from flask import render_template, url_for, flash, redirect, request
from tool import app
import os
from tool.forms import input, leaderboard_configuration, inthemoment_configuration, selector
from flask import Flask, flash, request, redirect, url_for, send_file
from werkzeug.utils import secure_filename
from flask_wtf import FlaskForm
from flask_wtf.file import FileField, FileRequired
from tool.models import leaderboard, inthemoment
from tool.utils import generate_leaderboard, check_file, get_filepath, upload_config, allowed_file, update_configuration_rankpool_pseudoname, update_configuration, import_file_to_database, populate_dropdown, populate_BTL, get_leaderboard_rankpool, get_inthemoment_rankpool, delete_existing_database, create_configuration, delete_existing_configuration, import_configuration_to_database, temp_to_confirm_config, create_configuration_file

@app.route("/", methods=["GET", "POST"])
@app.route("/input", methods=["GET", "POST"])
def home():
    form=input()
    leaderboard_file=''
    inthemoment_file=''
    
    if request.method == 'POST':

        if 'submit' in request.form:
            delete_existing_database()
            import_file_to_database()
            delete_existing_configuration()
            create_configuration()
            create_configuration_file()

        if 'generate' in request.form:
            if request.form['generate']=='Generate HTML':
                create_configuration_file()
                return redirect(url_for('config'))

        leaderboard_file = request.files['leaderboard']
        if leaderboard_file and allowed_file(leaderboard_file.filename):
            leaderboard_file.save(os.path.join(app.config['UPLOAD_FOLDER'], "Leaderboard.txt"))
        elif leaderboard_file.filename!='':
            flash("Incorrect leaderboard file extention")

        inthemoment_file = request.files['inthemoment']
        if inthemoment_file and allowed_file(inthemoment_file.filename):
            inthemoment_file.save(os.path.join(app.config['UPLOAD_FOLDER'], "InTheMoment.txt"))
        elif inthemoment_file.filename!='':
            flash("Incorrect inthemoment file extention")
        return render_template("input.html", form=form, leaderboard_message=check_file("Leaderboard.txt"), inthemoment_message=check_file("InTheMoment.txt"))
    return render_template("input.html", form=form, leaderboard_message=check_file("Leaderboard.txt"), inthemoment_message=check_file("InTheMoment.txt"))

@app.route("/configurator", methods=["GET", "POST"])
def config():
    form=selector()
    chairman_circle_data=[]
    current_BU_TEAM_LEVEL=''
    if request.method == 'POST':
        status=[]
        upload_config_file=''
        if request.files.get('Upload_Config')!=None:
            upload_config_file = request.files['Upload_Config']
            if upload_config_file.filename!='':
                #pass
                status = upload_config(upload_config_file, upload_config_file.filename)
                print(status)
                flash(status)
                if(status=="success"):
                    print("bhaukal")
                    #upload_config_file_1.save(os.path.join(app.config['UPLOAD_FOLDER'], "configuration.txt"))
                    temp_to_confirm_config()
                    delete_existing_configuration()
                    import_configuration_to_database()
        #print(str(request.get_json()))
        if request.get_json() != None:
            data = request.get_json()
            # Update Configuration
            if data.get('current_BU_TEAM_LEVEL_NAME')!=None:
                current_BU_TEAM_LEVEL = data['current_BU_TEAM_LEVEL_NAME']
                #print("current_BU_TEAM_LEVEL_NAME: "+current_BU_TEAM_LEVEL)                
                #generate_leaderboard(current_BU_TEAM_LEVEL)
                chairman_circle_data = generate_leaderboard(current_BU_TEAM_LEVEL)
                #print(chairman_circle_data)
            if data.get('Download') != None:
                print("ssssss")
            elif data.get('Refresh_config') != None:
                print("Refreshing")
                delete_existing_configuration()
                create_configuration()
                create_configuration_file()
                form_1=selector()
                form_1 = populate_dropdown(form_1)
                return render_template("configurator.html", form=form_1)
            elif data.get('Rank_Pool_Visibility') != None:
                config_id = data['Id']
                rankpool_visibility_flag = data['Rank_Pool_Visibility']
                print(config_id+" "+rankpool_visibility_flag)
                update_configuration(config_id, rankpool_visibility_flag)
            elif data.get('rankpool_pseudoname') != None:
                print("rankpool_pseudoname")
                update_configuration_rankpool_pseudoname(data['Id'], data['rankpool_pseudoname'])
        leaderboard_rankpool = get_leaderboard_rankpool(str(form.select_BU.data), str(form.select_BU_TEAM_LEVEL.data))
        inthemoment_rankpool = get_inthemoment_rankpool(str(form.select_BU.data), str(form.select_BU_TEAM_LEVEL.data))
        if 'rankpoolvisibilityflag' in request.form:
            pass
            #flash("Check_BOX_UNSELECTED: ")
        if 'select_BU' in request.form:
            pass
            #flash("BU: "+request.form['select_BU'])
        if 'select_BU_TEAM_LEVEL' in request.form:
            pass
            #flash("BU_TEAM_LEVEL: "+request.form['select_BU_TEAM_LEVEL'])
        
        form = populate_BTL(form, str(form.select_BU.data))      
        #flash("NO REQUEST")  
        print("returned: "+str(chairman_circle_data)+" "+current_BU_TEAM_LEVEL)
        return render_template("configurator.html", form=form, chairman_circle_data=chairman_circle_data,  status=status, leaderboard_rankpool=leaderboard_rankpool, inthemoment_rankpool=inthemoment_rankpool)
    else:
        print("returned:xyzzzz "+str(chairman_circle_data))
        form = populate_dropdown(form)
        return render_template("configurator.html", form=form, chairman_circle_data=chairman_circle_data)

@app.route("/leaderboard_document")
def leaderboard_document():
    return send_file("Uploads/Leaderboard.txt", as_attachment=True)

@app.route("/inthemoment_document")
def inthemoment_document():
    return send_file("Uploads/InTheMoment.txt", as_attachment=True)

@app.route("/configuration_document")
def configuration_document():
    #print("CHAMUNDA")
    create_configuration_file()
    return send_file("Uploads/configuration.txt", as_attachment=True)
