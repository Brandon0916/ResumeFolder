#buliding the data frame
rm(list = ls())
A=rep(c(-1,1),4)
B=rep(c(rep(-1,2),rep(1,2)),2)
C=rep(c(rep(-1,4),rep(1,4)))

#enter the data and complete the data frame.
SpicyLevel=c(20,38,21,35,11,22,11,23,16,41,25,31,9,26,11,29)
SpicyLevel_Data <- data.frame(SpicyLevel, A,B,C)

#analysis the data 
res.lm<-lm(SpicyLevel~A*B*C, data=SpicyLevel_Data)
summary(res.lm)
res.aov<-aov(SpicyLevel~A*B*C,data=SpicyLevel_Data)
summary(res.aov)

#Normal probability plot
library(daewr)
fullnormal(coef(res.lm)[-1],alpha=.025)


#Projected model
res.aov<-aov(SpicyLevel~A*C,data=SpicyLevel_Data)
summary(res.aov)
res.lm<-lm(SpicyLevel~A*C, data=SpicyLevel_Data)
summary(res.lm)

#Final model - remove non-significant terms
res.lm<-lm(SpicyLevel~A*C-A:C, data=SpicyLevel_Data)
summary(res.lm)
res.aov<-aov(SpicyLevel~A*C-A:C,data=SpicyLevel_Data)
summary(res.aov)
#Residual Analysis
#Normality
SpicyLevel_residuals=res.aov$residuals
qqnorm(SpicyLevel_residuals, ylim=c(min(SpicyLevel_residuals),max(SpicyLevel_residuals)), main = "Normal Q-Q Plot for Residuals",
       xlab = "Theoretical Quantiles", ylab = "Sample Quantiles- Modified",
       plot.it = TRUE, datax = FALSE)

qqline(SpicyLevel_residuals, datax = FALSE, distribution = qnorm)
#Test normality using Shapiro Wilks
shapiro.test(SpicyLevel_residuals)


#Check Variance
Fitted_values=res.aov$fitted.values
plot(Fitted_values,SpicyLevel_residuals,ylab="Residuals",xlab="Fitted Values")
abline(h=0)


# Block design
#Introducing Block effect
#Modification 1- counfound ABCD with blocks
Block1=c(1,2,1,2,2,1,1,2,2,1,1,1,2,2,1,2)
#Modified response variable
SpicyLevelRate_Mod=SpicyLevel;
SpicyLevelRate_Mod[Block1==1]=SpicyLevelRate_Mod[Block1==1]-1
SpicyLevelRate_Data_Mod <- data.frame(SpicyLevelRate_Mod, A,B,C)
res.aov2<-aov(SpicyLevelRate_Mod~A*B*C+Block1,data=SpicyLevelRate_Data_Mod)
summary(res.aov2)
res.lm2<-lm(SpicyLevelRate_Mod~A*B*C+Block1, data=SpicyLevelRate_Data_Mod)
fullnormal(coef(res.lm2)[-1],alpha=.025)
