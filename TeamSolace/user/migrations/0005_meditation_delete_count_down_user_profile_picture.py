# Generated by Django 4.1.1 on 2022-10-06 07:19

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('user', '0004_remove_user_profile_picture'),
    ]

    operations = [
        migrations.CreateModel(
            name='Meditation',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('duration', models.TimeField()),
                ('meditation_type', models.CharField(choices=[('mindfullness', 'mindfullness'), ('breathing', 'breathing'), ('mantra', 'mantra'), ('walking', 'walking')], max_length=50, null=True)),
            ],
        ),
        migrations.DeleteModel(
            name='Count_down',
        ),
        migrations.AddField(
            model_name='user',
            name='profile_picture',
            field=models.ImageField(default='default.jpg', upload_to='profile_pics'),
        ),
    ]
