# 2020 US President Election Project

This Project is created on August 2020, The aim to this project is to learn the basic process of the data science. As due to the first time doing project alone and the dataset are quit large, there are serval problems occurs during this project.

The purpose of the project are using the data scrapt from Tweeter to apply some machine learning models to predict the result of the election. There are serveral training model will applied to the words that the people post on the tweeter. The result that will give to a tweeter for "support" or "not support".

The dataset are driectly scrapt from tweeter with the tweeter developer account. The data will pre-cleaned with serveral ways and the cleaned data will only contains the words.

The python notebook will get the brief instruction of the process that used in the analysis and the use of various methods.
Twe
There are total of 4 parts of the data will be extracted from the tweeter, The data that related to the general topics of the election and the topics related to the specific candiantes. The topics "#Biden" and "Trump" are slected to use for general topics. However, although this study are very limited becuase only use one topic for each candiantes but it do conatins large number of the data for each hastages.
This analysis are based on the data that the people post on the tweeter. The project are only used for research.

The Main Python Notebook script is [here](https://github.com/Brandon0916/ResumeFolder/blob/main/DataScience/2020_Election_Data/2020%20Elecion%20Data%20Analysis.ipynb)

The project are using the reference of process: [Data-Science-Community](https://github.com/Data-Science-Community-SRM/Forecasting-US-Elections)

As a learning process, there are some process are using the code directly from the reference course above. Most of the method are trying to using another way or using a more efficient way to do.

## The modules used in this project
* Tweepy
* Pandas
* numpy
* Matplotlib
* datetime
* re
* collections
* wordcloud
* nltk

## The process of this project
1.Data collection:
  * Using Tweepy to get the data from tweeter
2.Data cleaning:
  * Using Re, Pandas to clean the emoji, link, hyperlink of the tweeter 
  * Filter the re-tweeter. 
  * Using stopwords to clean out useless words.
  * transfrom the sentence to the words tokens.
3.Data Visulization:
  * [Word Cloud](https://github.com/Brandon0916/ResumeFolder/blob/main/DataScience/2020_Election_Data/Biden_Wordcloud.PNG)
  * graph to show the female, male.
  * graph to show the verified users or unverified users.
4.Data analysis(Current doing):
  * Sentiment analysis
  * prediction


### Problems currently meet:
1. When geting the data, the tweepy could not get the data correctly. Need more efficient algorithm or tools to gain the data. Also, sometime the data overwrite, the project could not continued properly.
