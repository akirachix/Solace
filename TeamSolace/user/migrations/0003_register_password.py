# Generated by Django 4.1.2 on 2022-10-22 17:17

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('user', '0002_chatbot_countdowntimer_discoverylist_music_and_more'),
    ]

    operations = [
        migrations.AddField(
            model_name='register',
            name='password',
            field=models.CharField(max_length=15, null=True),
        ),
    ]
