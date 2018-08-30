 var flgCheckError = isUrlValid(context.proxyRequest.url);
 if (flgCheckError){
     context.proxyResponse.status = 400;
 }
 
 function isUrlValid(userInput) {
        if (userInput.match(/select/g) !== null)
            return true;
        else
            return false;
    }