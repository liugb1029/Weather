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

### 3. kubect start the project
```
kubectl create -f ./
```

