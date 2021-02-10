from flask import Flask, render_template, flash
from flask_sqlalchemy import SQLAlchemy 
from sqlalchemy import func, distinct
from flask_wtf import FlaskForm 
from wtforms import SelectField
from wtforms.ext.sqlalchemy.fields import QuerySelectField

app = Flask(__name__)

app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///site.db'
app.config['SECRET_KEY'] = 'secret'

db = SQLAlchemy(app)

class Choice(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(50))
    extra = db.Column(db.String(50))

    def __repr__(self):
        return '[Choice {}]'.format(self.name)

def choice_query():
    return Choice.query

class ChoiceForm(FlaskForm):
    #opts = QuerySelectField(query_factory=choice_query, allow_blank=False, get_label='name')
    opts = QuerySelectField()
    xyz=SelectField(choices=[])

@app.route('/', methods=['GET', 'POST'])
def index():
    form = ChoiceForm()

    #form.opts.query = Choice.query.filter(Choice.id > 1)
    #form.opts.query = Choice.query.filter(Choice.name)
    #form.opts.query = Choice.query(func.count(Choice.name))
    #form.opts.query = Choice.query(func.count(Choice.id))
    #form.opts.query = Choice.query(func.count(Choice.id)).filter(Choice.id > 1)

    listt=[]
    sets={""}
    for name in Choice.query:
        sets.add(name)
    
    
    #xyz=Choice.query
    #xxy="SELECT DISTINCT choice.name AS choice_name FROM choice"
    #form.opts.query=xyz

    #form.opts.query=Choice.query

    code1=Choice.query.filter_by(name="name1")
    code3="SELECT DISTINCT name FROM Choice"
    code2=db.session.execute(code3)

    #form.opts.query=db.session.execute(code3)
    form.xyz.choices = [(Choices.name) for Choices in code2]

    for xxx in code2:
        flash(str(xxx['name']))

    form.opts.query=code1

    #xyz.choices=db.session.execute(code3)
    #flash(str(db.session.execute(code3).all()))
    #flash()
    flash(db.session.execute(code1))
    #form.opts.query = Choice.query(func.count(Choice.id)).group_by(Choice.name)

    if form.validate_on_submit():
        return '<html><h1>{}</h1></html>'.format(form.opts.data)

    return render_template('index.html', form=form)

app.run(debug=True)