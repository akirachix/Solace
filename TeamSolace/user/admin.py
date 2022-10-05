from django.contrib import admin

from user.models import  Count_down, User

# Register your models here.
class UserAdmin(admin.ModelAdmin):
    list_display=("first_name","last_name","email","password")
    search_fields=("first_name","last_name","email","password")
admin.site.register(User,UserAdmin)

class Count_downAdmin(admin.ModelAdmin):
    list_display=("timer",)
    search_fields=("timer",)
admin.site.register(Count_down,Count_downAdmin)

