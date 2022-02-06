import discord
import random
import csv
import pandas as pd

df = pd.read_csv('baby_names.csv', usecols = ['NAME'])
df.insert(0, 'START', df['NAME'].str[0])
print(df)

TOKEN = 'OTM5NjI4ODEzMDA3MDY5MjE0.Yf7nhg.SerV4kzXLrEGvmxLX_dRJtOnlLE'

client = discord.Client()

@client.event
async def on_ready():
    print("we have logged in as {0.user}".format(client))

@client.event
async def on_message(message):
    print("mic testing")
    user = message.author
    username = str(message.author).split('#')[0]
    user_message = str(message.content)
    channel = str(message.channel.name)
    print(f'{username}:{user_message} ({channel})')

    if message.author == client.user:
        return
    if message.channel.name == 'bot-testing':
        if user_message.lower()=='hello':
            await message.channel.send(f'Hello {username}')
            return
        elif user_message.lower()=='bye':
            await message.channel.send(f'See you later {username}')
            return
        elif user_message.lower()=='!name':
            response = f"What letter do you want your baby's name to start with?"
            await message.channel.send(response)
            msg = await client.wait_for('message', check=lambda message: message.author == user)
            start_letter = msg.content.upper()[0]
            names = df[df['START']==start_letter]
            name = names.sample()['NAME'].to_string(index=False)
            response = f"Your baby name idea is: {name}! What a lovely name <3"
            await message.channel.send(response)
            return

client.run(TOKEN)

