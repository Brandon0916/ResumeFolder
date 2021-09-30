# Covid-19 Track Dashboard

At very beginning of the pendemic, I want to use the information that displayed on BC CDC website to bulid a dashboard that can easily show the case number and alert people to avoid the place that may contain risks with Covid-19. However, due to the information restrict, the code has been changed a little.

## Use of the Packages: 

The main language I used is Python with the request and beautifulsoup module. The other help tools is Tableau to display the data in map. 

## Process of the Display: 
1. Get the Data from BC CDC:
  a). Test the request and beautifulsoup module are successful link the website
  b). Download the dataset from CDC website. The download dataset are named: "1.csv". (The name are using for test currently) 

2. Using the Tableau to display the data on the map and visulization the data distribution. The map are using from [Health Authority Boundaries](https://catalogue.data.gov.bc.ca/dataset/health-authority-boundaries) under [Open Government Licence - British Columbia](https://www2.gov.bc.ca/gov/content/data/open-data/open-government-licence-bc). 

3. Using the python to analysis the data (Current Working) 
4. Using D3 to build to visulization dashboard for the data. (Future working, estimated complete on December)

### Get the Data from website:
The origin website create by BC CDC is: [![](http://covid-19.bccdc.ca/index_files/logo.png)](http://www.bccdc.ca/health-info/diseases-conditions/covid-19/data)

The python notebook script are [here](https://github.com/Brandon0916/ResumeFolder/blob/main/DataScience/Covid/Scraping%20the%20COVID-19%20Data%20from%20Official%20Website.ipynb)

### Tableau 
This is a project that create by Tableau, some analysis are create. The dashboard are public on [Tableau Public Dashboard](https://public.tableau.com/views/Covid-19_16330301841440/StoryofCovid19?:language=en-US&publish=yes&:display_count=n&:origin=viz_share_link). The Tableau worksite is [here](COVID19_Data/Covid-19.twb). You can download the Tableau file for more details. The Tableau is using verison 2020.4 with the student license.

The current dashboard update on **Sept 29th,2021**. 
![](https://github.com/Brandon0916/ResumeFolder/blob/main/DataScience/Covid/Dashbord.png)


#### Analysis

There are serval approaches to analysis the Covid data. As long as the covid pandemic continuous, People will pay less attention on protecting themselves. We can clearly see from the visualization that Epidemic repeated three times.  According to the estimation, it will reach the peek again around sometime in October, 2021. Based on current data, it is very hard to say fully vaccine can help people escape for the covid.   

According to the analysis, there is no huge difference between sex for getting covid, but we do find the young people age group between 30-39 and 20-29 are increases. The trend for teenagers are also increase, this probably due to this age group do not get the vaccine. 

In conclusion, the overall data shows the number of cases is decrease when vaccine policy are applied, but vaccine cannot end of this pandemic. The number of cases are still increase and should be reach the peek around October.

Please be safe



