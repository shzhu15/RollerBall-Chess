export default class Cookies{
    //thanks to https://www.tek-tips.com/viewthread.cfm?qid=1481273
    static createCookie(name,value,days) {
        if (days) {
            var date = new Date();
            date.setTime(date.getTime()+(days*24*60*60*1000));
            var expires = "; expires="+date.toGMTString();
        }
        else var expires = "";
        document.cookie = name+"="+value+expires+"; path=/";
    }

    //thanks to https://www.tek-tips.com/viewthread.cfm?qid=1481273
    static readCookie(name) {
        var nameEQ = name + "=";
        var ca = document.cookie.split(';');
        for(var i=0;i < ca.length;i++) {
            var c = ca[i];
            while (c.charAt(0)==' ') c = c.substring(1,c.length);
            if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
        }
        return null;
    }

    static readCookieWithDefault(name, valueIfNull){
        let cookie = this.readCookie(name)
        if (cookie === null){
            return valueIfNull
        }
        else{
            return cookie;
        }
    }


}