#!/bin/bash
# pre-receive script
# push代码后会执行该脚本，校验不通过就拒绝push
# 注：一次push可能包含好多次commit，所以拿到的是list，需要遍历校验
 
# 校验的方法
validate(){
	# --- Arguments
	oldrev=$(git rev-parse $1)
	newrev=$(git rev-parse $2)
	refname="$3"
	 
	#拿到每次commit的id
	commitList=`git rev-list $oldrev..$newrev`
	# 输出
	# echo $commitList
	 
	split=($commitList)
	for code in ${split[@]}
	do
		echo "----------------------------------------"
		echo $code
		echo "detail: {"$(git cat-file commit $code)"}"
		# 根据commit id获取提交的备注信息
		message=`git cat-file commit $code | sed '1,/^$/d'`
		# echo $message
		
		regex='^(Add|Upd|Fix)[:：].*?[,，].*$'
		if [[ $message =~ $regex ]]; then
		  echo "----------------------------------------"
		else
			echo -e "\033[31m 提交失败: commit内容必须满足规范,参考↓ \033[0m"
			echo -e "\033[31m       例: Add：xxx功能，具体功能点描述 \033[0m"
			echo -e "\033[31m           ---------------------------- \033[0m"
			echo -e "\033[31m           |Add：新功能               | \033[0m"
			echo -e "\033[31m           |Upd：新功能的完善，补充   | \033[0m"
			echo -e "\033[31m           |Fix：修补bug，缺陷，优化  | \033[0m"
			echo -e "\033[31m           |Refactor：重构(非功能调整)| \033[0m"
			echo -e "\033[31m           ---------------------------- \033[0m"
			
			exit 1; #非0退出表示校验不通过,git将拒绝push
		fi
		
	done
}
 
 

while read oldrev newrev refname
do
	validate $oldrev $newrev $refname
done


