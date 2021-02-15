from tool import db

class leaderboard(db.Model):
    Id = db.Column(db.Integer, primary_key=True)
    RANK_POOL = db.Column(db.String(120))
    BU = db.Column(db.String(120))
    BU_TEAM_LEVEL = db.Column(db.String(120))
    FINAL_RANK = db.Column(db.Integer)
    FULLNAME = db.Column(db.String(120))

    def __repr__(self):
        return f"Leaderboard('{self.RANK_POOL}', '{self.BU}', '{self.BU_TEAM_LEVEL}', '{self.FINAL_RANK}','{self.FULLNAME}')"

class inthemoment(db.Model):

    Id = db.Column(db.Integer, primary_key=True)
    RANK_POOL = db.Column(db.String(120))
    BU = db.Column(db.String(120))
    BU_TEAM_LEVEL = db.Column(db.String(120))
    DIFFERENCE_CC_RANK = db.Column(db.Integer)
    FULLNAME = db.Column(db.String(120))

    def __repr__(self):
        return f"inthemoment('{self.RANK_POOL}', '{self.BU}', '{self.BU_TEAM_LEVEL}', '{self.DIFFERENCE_CC_RANK}','{self.FULLNAME}')"

class configuration(db.Model):

    Id = db.Column(db.Integer, primary_key=True)
    RANK_POOL = db.Column(db.String(120))
    RANK_POOL_PSEUDONAME = db.Column(db.String(120))
    DATA_TYPE = db.Column(db.String(120))   ## Leaderboard or InTheMoment
    RANK_POOL_VISIBILITY_FLAG = db.Column(db.Integer, default=1)
    BU_TEAM_LEVEL = db.Column(db.String(120))

    def __repr__(self):
        return f"Leaderboard('{self.RANK_POOL}', '{self.RANK_POOL_PSEUDONAME}', '{self.DATA_TYPE}', '{self.BU_TEAM_LEVEL}', '{self.RANK_POOL_VISIBILITY_FLAG}')"

class leaderboard_constants(db.Model):

    Parameter = db.Column(db.String(120), primary_key=True)
    parameter_value = db.Column(db.String(500))