<meta charset="UTF-8">
        <title>Happy Birthday</title>
        <style>
            .balloon {
             padding-top: 30px;
            }
            .balloon > div {
                width: 80px;
                height: 80px;
                background: rgba(182, 15, 97, 0.9);
                border-radius: 0;
                border-radius: 80% 80% 80% 80%;
                margin: 0 auto;
                position: absolute;
                padding: 10px;
                box-shadow: inset 17px 7px 10px rgba(182, 15, 97, 0.9);
                -webkit-transform-origin: bottom center;
            }
            .balloon > div:nth-child(1) {
                background: rgba(182, 15, 97, 0.9);
                left: 20px;
                box-shadow: inset 10px 10px 10px rgba(135, 11, 72, 0.9);
                -webkit-animation: balloon1 6s ease-in-out infinite;
                -moz-animation: balloon1 6s ease-in-out infinite;
                -o-animation: balloon1 6s ease-in-out infinite;
                animation: balloon1 6s ease-in-out infinite;
            }
            .balloon > div:nth-child(1):before {
                color: rgba(182, 15, 97, 0.9);
            }

            .balloon > div:nth-child(2) {
                background: rgba(242, 112, 45, 0.9);
                left: 470px;
                box-shadow: inset 10px 10px 10px rgba(222, 85, 14, 0.9);
                -webkit-animation: balloon2 6s ease-in-out infinite;
                -moz-animation: balloon2 6s ease-in-out infinite;
                -o-animation: balloon2 6s ease-in-out infinite;
                animation: balloon2 6s ease-in-out infinite;
            }
            .balloon > div:nth-child(2):before {
                color: rgba(242, 112, 45, 0.9);
            }
            
            .balloon > div:before {
                color: rgba(182, 15, 97, 0.9);
                position: absolute;
                bottom: -11px;
                left: 52px;
                content:"?";
                font-size: 1em;
            }
           
           
            /*BALLOON 1 4*/
           @-webkit-keyframes balloon1 {
                0%, 100% {
                    -webkit-transform: translateY(0) rotate(6eg);
                }
                50% {
                    -webkit-transform: translateY(-30px) rotate(-8deg);
                }
            }
            @-moz-keyframes balloon1 {
                0%, 100% {
                    -moz-transform: translateY(0) rotate(6deg);
                }
                50% {
                    -moz-transform: translateY(-30px) rotate(-8deg);
                }
            }
            @-o-keyframes balloon1 {
                0%, 100% {
                    -o-transform: translateY(0) rotate(6deg);
                }
                50% {
                    -o-transform: translateY(-30px) rotate(-8deg);
                }
            }
            @keyframes balloon1 {
                0%, 100% {
                    transform: translateY(0) rotate(6deg);
                }
                50% {
                    transform: translateY(-30px) rotate(-8deg);
                }
            }
      
            

           
            /* BAllOON 2 5*/
            @-webkit-keyframes balloon2 {
                0%, 100% {
                    -webkit-transform: translateY(0) rotate(6eg);
                }
                50% {
                    -webkit-transform: translateY(-30px) rotate(-8deg);
                }
            }
            @-moz-keyframes balloon2 {
                0%, 100% {
                    -moz-transform: translateY(0) rotate(6deg);
                }
                50% {
                    -moz-transform: translateY(-30px) rotate(-8deg);
                }
            }
            @-o-keyframes balloon2 {
                0%, 100% {
                    -o-transform: translateY(0) rotate(6deg);
                }
                50% {
                    -o-transform: translateY(-30px) rotate(-8deg);
                }
            }
            @keyframes balloon2 {
                0%, 100% {
                    transform: translateY(0) rotate(6deg);
                }
                50% {
                    transform: translateY(-30px) rotate(-8deg);
                }
            }
        </style>
        

       
        
        
        