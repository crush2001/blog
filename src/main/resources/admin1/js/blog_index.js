var updown = document.querySelector('.updown-menu');
        var lis = updown.children;
        for(var i=0;i<lis.length;i++){
            lis[i].onmouseover = function(){
                this.children[1].style.display = 'block';
            }
            lis[i].onmouseout = function(){
                this.children[1].style.display = 'none';
            }
        }

        $(function(){
            // 鼠标经过
            $(".updown-menu>li").mouseover(function(){
                // $(this) jQuery 当前元素
                // show显示元素
                $(this).children("ul").slideDown(200);
            })
            // 鼠标离开
            $(".updown-menu>li").mouseout(function(){
                // hide 隐藏元素
                $(this).children("ul").slideUp(200);
            })
        })