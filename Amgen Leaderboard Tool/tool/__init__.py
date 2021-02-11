from flask import Flask
from flask_sqlalchemy import SQLAlchemy
import os
from flask import Flask, flash, request, redirect, url_for
from werkzeug.utils import secure_filename
import pathlib

app = Flask(__name__)
app.config['SECRET_KEY']='89d71acdfab28d4d389875d35b14e380'
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///site.db'
db = SQLAlchemy(app)
path = pathlib.Path(__file__).parent.absolute()
path = os.path.join(path, "Uploads")
temp_path =  os.path.join(path, "temp")
UPLOAD_FOLDER = path
TEMP_UPLOAD_FOLDER = temp_path
ALLOWED_EXTENSIONS = {'xlsx', 'txt'}
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER
app.config['TEMP_UPLOAD_FOLDER'] = TEMP_UPLOAD_FOLDER

from tool import routes