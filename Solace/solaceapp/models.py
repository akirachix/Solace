from django.db import models

# Create your models here.
class Client(models.Model):
    full_name = models.CharField(max_length=225,null=True)
    email = models.EmailField()
    password=models.CharField(max_length=15)
    GENDER_CHOICES=(
       ("M", "Male"),
       ("F", "Female"),
       ("N","Other"),
   )
    gender= models.CharField(max_length=1,choices=GENDER_CHOICES,null=True)  
    profile_picture = models.ImageField(default='default.jpg', upload_to='profile_pics')

class Meditation(models.Model):
    meditation_choices= (
        ('mindfullness','mindfullness'),
        ('visualization','visaualization'),
        ('mantra','mantra'),
        ('movement','meditaion'),
    )
    meditation_type=models.CharField(max_length=50, choices=meditation_choices,null=True)
    count_down_timer= models.ForeignKey('CountdownTimer', null=True ,on_delete=models.CASCADE)
    music = models.ForeignKey('Music' , null=True,on_delete=models.CASCADE)

class CountdownTimer(models.Model):
    start_time = models.TimeField(null=True)
    stop_time =models.TimeField(null=True)

class Music(models.Model):
   music_choices =(
    ('ocean sound','ocean sound'),
    ('birds sound','birds sound'),
    ('nature sound','nature sound'),
   )
   music=models.CharField(max_length=50, choices=music_choices,null=True)

class Login(models.Model):
    user_name=models.CharField(max_length=30)
    password=models.CharField(max_length=30)
      
class Chatbot(models.Model):
    user_name = models.CharField(max_length=30)
    user_input =models.CharField(max_length=100)
    response = models.CharField(max_length=100)

class Notifications(models.Model):
    id = models.IntegerField(primary_key=True)
    title = models.CharField(max_length=200)
    body =models.CharField(max_length=200)
    created_at = models.DateTimeField(auto_now_add=True)
