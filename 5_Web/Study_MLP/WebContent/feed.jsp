<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel="stylesheet" href="./css/main.css">
    <link type="text/css" rel="stylesheet" href="./css/editProPopup.css">
    <link type="text/css" rel="stylesheet" href="./css/writeFeed.css">
    <script type="text/javascript" src="./js/indexScript.js"></script>
    <title>MLP Clone Coding</title>
</head>
<body>
    <header>
        <div class="Multicampus">
            <img src="./source/logo_mlp_b.png">
        </div>
        <div class="Search">
            <span>관심있는 주제, 키워드로 검색해보세요.</span>
            <span>🔍</span>
        </div>
        <div class="Profile">
            <span>➕</span>
            <span>💡</span>
            <img src="./source/ProfileImage1.jpg" class="profileImage">
        </div>
    </header>
    <nav>
        <h3>➰ 카테고리</h3>
        <ul>
            <li>피드</li>
            <li>지식콘텐츠</li>
            <li>캠퍼스</li>
            <li>나의학습</li>
        </ul>
    </nav>
    <div id="MainBody">
        <div id="LeftBody">
        <div id="LeftProfile">
            <div>
                <img src="./source/BasicProfileImage.png" class="profileImage">
                <div>
                    <h2>${user.name }</h2>
                    <p>[현대이지웰] Java 풀스택 개발자 아카데미 5회차 · K-디지털</p>
                </div>                
            </div>
            <div>
                <span>팔로워 </span><span>0</span>
                |
                <span>팔로잉 </span><span>0</span>
            </div>
            <div>
                <p>🥈🥇</p>
                <p onclick="showEditProfile();">프로필 수정</p>
            </div>
        </div>
        <div id="LeftFeed">
            <h2>전체 피드</h2>
            <ul>
                <li>📢 알려드립니다!</li>
                <li>우리회사 피드</li>
                <li>팔로잉 피드</li>
                <li>캠퍼스 피드</li>
                <li>내가 작성한 피드</li>
                <li>저장한 피드</li>
            </ul>
        </div>
        <div id="LeftFriend">
            <p>친구 추천</p>
            <p><</p>
            <p>></p>
            <div class="FriendList">
                <img src="./source/ProfileImage2.png" style="width: 100px;">
                <p>박도도</p>
                <p>[현대이지웰] Java 풀스택 개발자 아카데미 5회차 · K-디지털</p>
            </div>
            <div class="FriendList">
                <img src="./source/ProfileImage3.png" style="width: 100px;">
                <p>윤시시</p>
                <p>[현대이지웰] Java 풀스택 개발자 아카데미 5회차 · K-디지털</p>
            </div>
        </div>
        </div>
        <div id="RightBody">
        <div id="RightBasic">
            <h3>전체 피드 📌</h3>
            <button type="button" onclick="showWriteForm();" id="writeBtn">+ 피드작성</button>
        </div>
        <div id="RightSearch">
            <p>
                <input type="text" placeholder="검색어를 입력해주세요.">
                🔍
            </p>
            <p>
                <select>
                    <option>최신순</option>
                    <option>조회순</option>
                    <option>좋아요순</option>
                    <option>댓글순</option>
                </select>
            </p>
            <img src="./source/icon1-1.png">
            <img src="./source/icon2-2.png">
            <img src="./source/icon3-2.png">
        </div>
        <div class="RightFeeds">
            <div class="FeedProfile">
                <img src="./source/ProfileImage2.png">
                <h4>박도도</h4>
                <p>2024년 K-디지털트레이닝 신기술 유형 · K-디지털</p>
                <p>💬</p>
            </div>
            <div class="FeedContents">
                <p>06/12</p>
                <span>[5차/현대이지웰] Java 풀스택 개발자 > </span>
                <span>⑤설문 및 기타공지</span>
                <h3>[교과목 평가안내] 서비스 개발언어 (6/17)</h3>
                <div class="feed-text">
                  안녕하세요 여러분 ~<br>
                  다음주 6월 17일(화) 오후 5시 &lt;서비스 개발 언어&gt; 교과목 평가가 있습니다.<br><br>
                  ＊ 난이도가 높지 않습니다~! 부담 갖지 마세요~!<br><br>
                                
                  * 일시: 6/17(월), 오후 5시 ~ (60분 제한)<br>
                  - 시험은 강사님 설문을 먼저 참여하셔야 응시 가능합니다.<br>
                  - 시험은 '객관식 + O,X'으로 총 20문제 입니다.<br>
                  - 시험은 필수 과정으로, 미응시 시 해당 교과목 '미이수' 처리 됩니다.<br><br>
                                
                  과정 수료증에 해당 교과목 '미이수' 표시<br>
                  60점 미만이신 분들은 추후 새로운 일정을 잡아 교육 종료 이후에 재시험을 보셔야 합니다.
                </div>
                <img src="./source/Content1.png">
                <div class="FeedTag">
                    <p>시험</p>
                </div>
                <div>
                    <span>👀 20</span>
                    <span>❤ 0</span>
                    <span>📤 0</span>
                    <span>🤍 좋아요</span>
                    <span>📤 공유</span>
                    <span>📍 저장</span>
                </div>
                <hr>
                <form>
                    <img src="./source/BasicProfileImage.png" class="profileImage">
                    <input type="text" placeholder="댓글을 입력해 주세요.">
                    <input type="submit" value="등록">
                </form>
                <div>
                    <p>🗨 댓글 0</p>
                </div>
            </div>
        </div>
        </div>
    </div>    

    <!-- 북마크 & Top 버튼 -->
    <div id="floatButton">
        <button class="floatbtns" onclick="goToBMark();">📌</button>
        <br>
        <button class="floatbtns" onclick="goToTop();">△<br>TOP</button>
    </div>


    <!-- 프로필 수정 팝업 -->
    <div id="editProfile">
        <h3>프로필 수정</h3>
        <div class="editProImg">
            <form>
                <div class="uploadProImg">
                    <img src="./source/BasicProfileImage.png" onclick="uploadProImg();">
                    <div class="uploadOverlay">사진 등록</div>
                    <!-- 숨겨진 파일 input -->
                    <input type="file" id="fileInput" accept="image/*" style="display:none;" onchange="changeImage(event)">
                </div>
                <div class="addIntroduce">
                    <h3>${user.name }</h3>
                    <input type="text" placeholder="소개글을 입력하세요.">
                    <p>0 / 30</p>
                    <button type="button">추천 키워드</button>
                </div>
                <div class="userInfo">
                    <table>
                        <tr>
                            <th>부서</th>
                            <td>[현대이지웰] Java 풀스택 개발자 아카데미 5회차</td>
                        </tr>
                        <tr>
                            <th>회사</th>
                            <td>K-디지털</td>
                        </tr>
                        <tr>
                            <th>이메일주소</th>
                            <td>${user.email }</td>
                        </tr>
                        <tr>
                            <th>전화번호</th>
                            <td>${user.phone }</td>
                        </tr>
                        <tr>
                            <th>사번</th>
                            <td></td>
                        </tr>
                        <tr>
                            <th>직위명</th>
                            <td></td>
                        </tr>
                        <tr>
                            <th>직급명</th>
                            <td></td>
                        </tr>
                        <tr>
                            <th>성별</th>
                            <td></td>
                        </tr>
                        <tr>
                            <th>생년월일</th>
                            <td></td>
                        </tr>
                    </table>
                </div>
                <button class="cancle" onclick="cancel();" type="button">취소</button>
                <input type="submit" value="저장">
            </form>
        </div>
    </div>

    <!-- 글쓰기 팝업 -->
    <div id="writeFeed">
        <form>
            <input type="text" placeholder="제목을 입력해주세요.">
            <input type="text" placeholder="키워드를 입력해 주세요. (엔터로 여러 키워드 등록 가능)">
            <textarea placeholder="타인의 저작물을 무단 인용하는 경우 저작권 침해에 해당할 수 있으니, 저작권 준수를 부탁드립니다."></textarea>
            <div class="button-group">
                <button type="button" onclick="cancel();">취소</button>
                <input type="submit" value="등록">
            </div>            
        </form>
    </div>

    <!-- 배경 오버레이 -->
    <div id="screenOverlay"></div>
</body>
</html>

