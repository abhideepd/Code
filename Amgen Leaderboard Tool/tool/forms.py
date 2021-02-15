from flask_wtf import FlaskForm
from flask_wtf.file import FileField, FileAllowed
from wtforms import StringField, PasswordField, SubmitField, BooleanField, TextAreaField, SelectField
from wtforms.validators import DataRequired, Length, Email, EqualTo, ValidationError
from wtforms.ext.sqlalchemy.fields import QuerySelectField

class input(FlaskForm):
    
    leaderboard=FileField('Leaderboard', validators=[FileAllowed(['txt'])])
    inthemoment=FileField('InTheMoment', validators=[FileAllowed(['txt'])])    
    submit=SubmitField('Submit')
    load_previous=SubmitField('Load Previous')
    generate=SubmitField('Preview HTML')

class leaderboard_configuration(FlaskForm):
    
    leaderboard_bu=SelectField('BU', choices=[])
    leaderboard_buteamlevel=SelectField('BU_TEAM_LEVEL', choices=[])
    leaderboard_rankpool=SelectField('RANK_POOL', choices=[])

class inthemoment_configuration(FlaskForm):
    
    inthemoment_bu=SelectField('BU', choices=[])
    inthemoment_buteamlevel=SelectField('BU_TEAM_LEVEL', choices=[])
    inthemoment_rankpool=SelectField('RANK_POOL', choices=[])
    username = StringField('Username', validators=[DataRequired(), Length(min=2, max=20)])

class selector(FlaskForm):
    Upload_Config=FileField('Upload Config', validators=[FileAllowed(['txt'])])
    select_BU = SelectField('BU', choices=[])
    select_BU_TEAM_LEVEL = SelectField('BU_TEAM_LEVEL', choices=[])
    submit_BU = SubmitField('Submit BU')
