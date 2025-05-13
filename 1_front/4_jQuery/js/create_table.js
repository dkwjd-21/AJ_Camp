function makeTable(rowList)
{
    // rowList : emplist.xml의 <ROW> 들
    // table 태그 만들기 -> tr 만들기 -> td 만들기 -> 값 넣기  
    
    // 1. table 태그 생성
    let $table = $("<table border=1>");

    // 2. 컬럼의 이름 가져오기 -> tr 태그 생성
    // ROW의 자식태그들의 태그 이름
    let $tr = $("<tr>");
    
    for(let i=0;i<rowList.eq(0).children().length;i++)
    {
        // rowList의 n번째의(n값 상관X) 자식들의 길이만큼 반복문 실행
        let $td = $("<td>").append(rowList.eq(0).children().eq(i).prop("tagName"));

        $tr.append($td);
    }
    $table.append($tr);

    // 3. 나머지들 다 테이블로 만들기
    for(let i=1; i<rowList.length; i++)
    {
        // rowList 개수만큼 반복
        $tr = $("<tr>");
        // console.log($tr);
        
        // tr 태그 1개 만들었다
        for(let j=0; j<rowList.eq(i).children().length;j++)
        {
            let $td = $("<td>").append(rowList.eq(i).children().eq(j).text());

            $tr.append($td);
        }
        // table에 tr 추가 
        $table.append($tr);
    }

    return $table;
}