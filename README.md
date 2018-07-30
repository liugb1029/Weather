# Requirements
+ **Redis** 3.2 (or newer)
+ **Maven** v3.0.*(or newer)
+ **Java** 1.8
+ **SpringCloud** Finchley.RELEASE
+ **SpringBoot** 2.0.3.RELEASE
+ **Jib** 0.9.6


# Quickstart
### 1. Clone the project
```
git clone https://github.com/sugare/Weather.git
cd Weather
```

### 2. If you can connect to the internet, you can change the docker hub directly.

```
cd microservice-k8s-template
```
***in mac***

```
for i in *;do sed -i "" 's#test.caicloudprivatetest.com/library#sugare#g' $i;done
```
***in linux***
```
for i in *;do sed -i 's#test.caicloudprivatetest.com/library#sugare#g' $i;done

```

### 3. kubectl start the project
```
kubectl create -f ./
```

### 4. check status
```
kubectl get pods | egrep -v "redis|eureka|collection|data|zuul|report"
kubectl get svc | egrep -v "redis|eureka|collection|data|zuul|report"
```

### 5. Open your browser and enter the address
```
http://<master-ip>:30083/report/cityId/101010500
```